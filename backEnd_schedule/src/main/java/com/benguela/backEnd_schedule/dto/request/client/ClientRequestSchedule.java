package com.benguela.backEnd_schedule.dto.request.client;

import com.benguela.backEnd_schedule.model.Employer;
import com.benguela.backEnd_schedule.model.ServiceProvided;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ClientRequestSchedule {
    private String email;
    private String phoneNumber;
    private Employer employer;
    private List<ServiceProvided> servicesProvided;
    private LocalDate day;
    private LocalTime time;

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Employer getEmployer() {
        return employer;
    }

    public List<ServiceProvided> getServicesProvided() {
        return servicesProvided;
    }

    public LocalDate getDay() {
        return day;
    }

    public LocalTime getTime() {
        return time;
    }
}
