package com.gabrielle.Personal_Expenses.entity;

import com.gabrielle.Personal_Expenses.dto.userDTO;
import com.gabrielle.Personal_Expenses.entity.enums.situacionUser;

import java.util.Objects;

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
@Table
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
    @Column()
    private situacionUser situacion;
    
    public userEntity(userDTO user) {
        BeanUtils.copyProperties(user, this);
    }

    public userEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public situacionUser situacion() {
        return situacion;
    }

    public void setSituacion(situacionUser situacion) {
        this.situacion = situacion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        userEntity other = (userEntity) obj;
        return Objects.equals(id, other.id);
    }
}
