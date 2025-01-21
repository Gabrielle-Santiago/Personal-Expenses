package com.gabrielle.Personal_Expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.gabrielle.Personal_Expenses.authentication.user.User;

public interface UserRepository extends JpaRepository<User, String>{
    UserDetails findByLogin(String login);
}
