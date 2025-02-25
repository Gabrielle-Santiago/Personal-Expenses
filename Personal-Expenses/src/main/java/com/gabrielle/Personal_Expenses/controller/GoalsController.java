package com.gabrielle.Personal_Expenses.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.gabrielle.Personal_Expenses.entity.Goal;
import com.gabrielle.Personal_Expenses.service.GoalsService;

@RestController
@RequestMapping("/add")
public class GoalsController {
    
    private final GoalsService goalsService;

    public GoalsController(GoalsService goalsService) {
        this.goalsService = goalsService;
    }

    @GetMapping("/goalsAll")
    public List<Goal> getGoals() {
        return goalsService.getAllGoals();
    }

    @PostMapping("/goals")
    public Goal createGoal(@RequestBody Goal goal) {
        return goalsService.addGoal(goal);
    }

    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable Long id) {
        goalsService.deleteGoal(id);
    }
}
