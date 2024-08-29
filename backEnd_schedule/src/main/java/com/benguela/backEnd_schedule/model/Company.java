package com.benguela.backEnd_schedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Company extends EntityBase{
    private int fiscalNumber;
    @OneToMany(mappedBy = "company")
    private Set<UserSchedule> userScheduleSet;

    @OneToMany(mappedBy = "company")
    private Set<Employer> employerSet;
}
