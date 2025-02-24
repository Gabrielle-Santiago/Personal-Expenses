package com.gabrielle.Personal_Expenses.dto;

import com.gabrielle.Personal_Expenses.authentication.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role, String email) {
} 
