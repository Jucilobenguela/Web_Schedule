package com.benguela.backEnd_schedule.model;

import java.util.Date;

public class ServiceProvided extends EntityBase{
    Date duration;

    public ServiceProvided(String serviceProvidedName, Date duration) {
        super(serviceProvidedName);
        this.duration = duration;
    }
    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }
}
