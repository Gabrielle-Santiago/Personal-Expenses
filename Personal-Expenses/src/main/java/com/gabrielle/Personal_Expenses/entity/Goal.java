package com.gabrielle.Personal_Expenses.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "goals")
public class Goal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public Goal(){}

    public Goal(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
