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
    @NotNull
    private Company company;
    public Employer(String name, String email, Company company) {
        super(name);
        this.email=email;
        this.company=company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
