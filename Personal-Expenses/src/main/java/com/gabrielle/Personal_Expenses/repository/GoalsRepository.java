package com.gabrielle.Personal_Expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielle.Personal_Expenses.entity.Goal;

public interface GoalsRepository extends JpaRepository<Goal, Long> {
}
