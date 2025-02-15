package com.gabrielle.Personal_Expenses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielle.Personal_Expenses.dto.ExpenseIncomeDTO;

@Repository
public interface ExponseIncomeRepository extends JpaRepository<ExpenseIncomeDTO, Long>{
    List<ExpenseIncomeDTO> findByType(String type);
}
