package com.benguela.backEnd_schedule.model;

import jakarta.persistence.Entity;


@Entity
public class ServiceProvided extends EntityBase{
    private int durationMinute;

    public ServiceProvided(String serviceProvidedName, int durationMinute) {
        super(serviceProvidedName);
        this.durationMinute = durationMinute;
    }
    public int getDurationMinute() {
        return durationMinute;
    }

    public void setDurationMinute(int durationMinute) {
        this.durationMinute = durationMinute;
    }
}
