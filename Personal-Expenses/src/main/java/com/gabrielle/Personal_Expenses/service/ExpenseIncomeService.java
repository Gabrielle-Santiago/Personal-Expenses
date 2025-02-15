package com.gabrielle.Personal_Expenses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielle.Personal_Expenses.dto.ExpenseIncomeDTO;
import com.gabrielle.Personal_Expenses.repository.ExponseIncomeRepository;

@Service
public class ExpenseIncomeService {

    @Autowired
    private ExponseIncomeRepository repository;

    public List<ExpenseIncomeDTO> getAllEntries() {
        return repository.findAll();
    }

    public List<ExpenseIncomeDTO> getEntriesByType(String type) {
        return repository.findByType(type);
    }

    public ExpenseIncomeDTO addEntry(ExpenseIncomeDTO entry) {
        return repository.save(entry);
    }

    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }
}
