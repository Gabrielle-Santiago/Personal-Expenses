package com.gabrielle.Personal_Expenses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gabrielle.Personal_Expenses.dto.ExpenseIncomeDTO;
import com.gabrielle.Personal_Expenses.service.ExpenseIncomeService;

@RestController
@RequestMapping("/home")
public class ExpenseIncomeController {

    @Autowired
    private ExpenseIncomeService service;

    @GetMapping("/all")
    public List<ExpenseIncomeDTO> getAllEntries() {
        return service.getAllEntries();
    }

    @GetMapping("/{type}")
    public List<ExpenseIncomeDTO> getEntriesByType(@PathVariable String type) {
        return service.getEntriesByType(type);
    }

    @PostMapping("/add")
    public ExpenseIncomeDTO addEntry(@RequestBody ExpenseIncomeDTO entry) {
        return service.addEntry(entry);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        service.deleteEntry(id);
    }
}
