package com.gabrielle.Personal_Expenses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielle.Personal_Expenses.dto.userDTO;
import com.gabrielle.Personal_Expenses.entity.userEntity;
import com.gabrielle.Personal_Expenses.repository.userRepository;

@Service
public class userService {
    
    @Autowired
    private userRepository userRepository;

    public List<userDTO> listUser() {
        List<userEntity> user = userRepository.findAll();
        return user.stream().map(userDTO::new).toList();
    } 

    public void insert(userDTO user) {
        userEntity userEntity = new userEntity(user);
        userRepository.save(userEntity);
    }

    public userDTO alter(userDTO user) {
        userEntity userEntity = new userEntity(user);
        return new userDTO(userRepository.save(userEntity));
    }

    public void exclude(Long id) {
        userEntity userEntity = userRepository.findById(id).get();
        userRepository.delete(userEntity);
    }

    public userDTO searchUserID(Long id) {
        return new userDTO((userEntity) userRepository.findById(id).get());
    }

    public List<userDTO> searchUser() {
        return userRepository.findAll().stream()
                .map(userDTO::new)
                .toList();
    }
}
