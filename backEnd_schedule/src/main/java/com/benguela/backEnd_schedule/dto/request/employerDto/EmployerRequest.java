package com.benguela.backEnd_schedule.dto.request.employerDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class EmployerRequest {
    @NotBlank
    private String name;
    private int dayOff;
    private Date starOfVacation;
    private Date endOfVacation;
    private int starWorkingHours;
    private int endWorkingHours;
    private Date notAvailableHours;
    private String email;

    public String getName() {
        return name;
    }

    public int getDayOff() {
        return dayOff;
    }

    public Date getStarOfVacation() {
        return starOfVacation;
    }

    public Date getEndOfVacation() {
        return endOfVacation;
    }

    public int getStarWorkingHours() {
        return starWorkingHours;
    }

    public int getEndWorkingHours() {
        return endWorkingHours;
    }

    public Date getNotAvailableHours() {
        return notAvailableHours;
    }

    public String getEmail() {
        return email;
    }
}
