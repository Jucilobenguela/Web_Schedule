package com.benguela.backEnd_schedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Company extends EntityBase {

    List<Employer> employers;
    List<Client> clients;

    public Company(String name) {
        super(name);
    }
}
