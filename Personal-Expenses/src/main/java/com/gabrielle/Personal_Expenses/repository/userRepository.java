package com.gabrielle.Personal_Expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielle.Personal_Expenses.entity.userEntity;

public interface userRepository extends JpaRepository<userEntity, Long> {
    
}
