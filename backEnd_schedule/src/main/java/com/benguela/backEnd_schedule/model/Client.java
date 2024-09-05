package com.benguela.backEnd_schedule.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Client extends EntityBase {

    private String email;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private Employer employer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "client_services", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<ServiceProvided> servicesProvided;
    private LocalDate day;
    private LocalTime time;

    public Client(String name) {
        super(name);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employee) {
        this.employer = employee;
    }

    public List<ServiceProvided> servicesProvided() {
        return servicesProvided;
    }

    public void setServices(List<ServiceProvided> servicesProvided) {
        this.servicesProvided = servicesProvided;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
