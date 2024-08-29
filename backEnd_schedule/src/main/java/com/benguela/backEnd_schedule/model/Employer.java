package com.benguela.backEnd_schedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;

import java.util.Date;
import java.util.Set;


@Entity
public class Employer extends EntityBase{
    int dayOff;
    Date starOfVacation;
    Date endOfVacation;
    int starWorkingHours;
    int endWorkingHours;
    Date notAvailableHours;
    private String password;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "userSchedule_id")
    private UserSchedule userSchedule;

    @OneToMany(mappedBy = "employer")
    private Set<Schedule> scheduleSet;
    public Employer(String name, String password) {
        super(name);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDayOff() {
        return dayOff;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }

    public Date getStarOfVacation() {
        return starOfVacation;
    }

    public void setStarOfVacation(Date starOfVacation) {
        this.starOfVacation = starOfVacation;
    }

    public Date getEndOfVacation() {
        return endOfVacation;
    }

    public void setEndOfVacation(Date endOfVacation) {
        this.endOfVacation = endOfVacation;
    }

    public int getStarWorkingHours() {
        return starWorkingHours;
    }

    public void setStarWorkingHours(int starWorkingHours) {
        this.starWorkingHours = starWorkingHours;
    }

    public int getEndWorkingHours() {
        return endWorkingHours;
    }

    public void setEndWorkingHours(int endWorkingHours) {
        this.endWorkingHours = endWorkingHours;
    }

    public Date getNotAvailableHours() {
        return notAvailableHours;
    }

    public void setNotAvailableHours(Date notAvailableHours) {
        this.notAvailableHours = notAvailableHours;
    }
}
