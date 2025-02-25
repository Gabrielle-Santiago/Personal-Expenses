package com.gabrielle.Personal_Expenses.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gabrielle.Personal_Expenses.entity.Goal;
import com.gabrielle.Personal_Expenses.repository.GoalsRepository;

@Service
public class GoalsService {
    
    private final GoalsRepository goalsRepository;

    public GoalsService(GoalsRepository goalsRepository) {
        this.goalsRepository = goalsRepository;
    }

    public List<Goal> getAllGoals() {
        return goalsRepository.findAll();
    }

    public Goal addGoal(Goal goal) {
        return goalsRepository.save(goal);
    }

    public void deleteGoal(Long id) {
        goalsRepository.deleteById(id);
    }
    
}
