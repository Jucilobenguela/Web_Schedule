package com.benguela.backEnd_schedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Client extends EntityBase {
    String phoneNumber;
    String email;
    @OneToMany(mappedBy = "client")
    private Set<Schedule> scheduleSet;
    public Client(String name) {
        super(name);
    }
}
