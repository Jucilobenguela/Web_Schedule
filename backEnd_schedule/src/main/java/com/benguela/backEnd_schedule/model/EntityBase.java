package com.benguela.backEnd_schedule.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public abstract   class EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;
    @NotBlank
    private String name;
    public EntityBase(String name){
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
