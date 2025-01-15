package com.gabrielle.Personal_Expenses.dto;

import org.springframework.beans.BeanUtils;

import com.gabrielle.Personal_Expenses.entity.userEntity;
import com.gabrielle.Personal_Expenses.entity.enums.situacionUser;

public class userDTO {

    private Long id;
    private String name;
    private String password;
    private String email;
    private String login;
    private situacionUser situacion;

    public userDTO(userEntity user) {
        BeanUtils.copyProperties(user, this);
    }

    public userDTO() {

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
}
