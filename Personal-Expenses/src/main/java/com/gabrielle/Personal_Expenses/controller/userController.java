package com.gabrielle.Personal_Expenses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielle.Personal_Expenses.dto.userDTO;
import com.gabrielle.Personal_Expenses.service.userService;

@RestController
@RequestMapping(value = "/user")
public class userController {
    
    @Autowired
    private userService userService;

    @GetMapping
    public List<userDTO> searchUser() {
        return userService.searchUser();
    }

    @PostMapping
    public void insert(@RequestBody userDTO user) {
        userService.insert(user);
    }

    @PutMapping
    public userDTO alter(@RequestBody userDTO user) {
        return userService.alter(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclude(@PathVariable Long id) {
        userService.exclude(id);
        return ResponseEntity.ok().build();
    }
}
