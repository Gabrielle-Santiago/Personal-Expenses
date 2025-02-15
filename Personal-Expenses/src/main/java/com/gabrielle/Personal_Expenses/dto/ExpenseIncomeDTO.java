package com.gabrielle.Personal_Expenses.dto;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "expenses_incomes")
public class ExpenseIncomeDTO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate date;
    private String description;
    private Double amount;
    private String type;

    public ExpenseIncomeDTO(){}

    public ExpenseIncomeDTO(LocalDate date, String description, Double amount, String type) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
