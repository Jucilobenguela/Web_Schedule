package com.benguela.backEnd_schedule.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Employer extends EntityBase{
    @Email
    private String email;
    public Employer(String name, String email) {
        super(name);
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
