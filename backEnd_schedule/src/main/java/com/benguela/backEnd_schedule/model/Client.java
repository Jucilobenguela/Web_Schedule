package com.benguela.backEnd_schedule.model;

import jakarta.persistence.Entity;

@Entity
public class Client extends EntityBase {
    String phoneNumber;
    String email;
    public Client(String name) {
        super(name);
    }
}
