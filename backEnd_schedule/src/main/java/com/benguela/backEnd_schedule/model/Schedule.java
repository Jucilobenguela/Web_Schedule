package com.benguela.backEnd_schedule.model;

import com.benguela.backEnd_schedule.util.ScheduleStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private Employer employer;

    @ManyToMany
    @JoinTable(name = "schedule_services", joinColumns = @JoinColumn(name = "schedule_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<ServiceProvided> services;

    private LocalDate date;
    private LocalTime time;

    @Enumerated(EnumType.STRING)
    private ScheduleStatus status;
    private int totalDurationMinutes;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Schedule(Client client, Employer employer, LocalDate date, LocalTime time, List<ServiceProvided> services) {
        this.client = client;
        this.employer = employer;
        this.date = date;
        this.time = time;
        this.services = services;
        this.totalDurationMinutes = calculateTotalDuration(services);
        this.status = ScheduleStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }
    public Schedule(){

    }

    private int calculateTotalDuration(List<ServiceProvided> services) {
        return services.stream().mapToInt(ServiceProvided::getDurationMinute).sum();
    }


}
