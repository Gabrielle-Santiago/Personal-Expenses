package com.gabrielle.Personal_Expenses.entity;

import com.gabrielle.Personal_Expenses.dto.userDTO;
import com.gabrielle.Personal_Expenses.entity.enums.situacionUser;

import org.springframework.beans.BeanUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NPL_USER")
public class userEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = true)
    private String login;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private situacionUser situacion;
    
    public userEntity(userDTO user) {
        BeanUtils.copyProperties(user, this);
    }

    public userEntity() {}
}
