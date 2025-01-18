// package com.gabrielle.Personal_Expenses.controller;

// import jakarta.validation.Valid;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.gabrielle.Personal_Expenses.dto.authenticationDTO;

// @RestController
// @RequestMapping("auth")
// public class authenticationController {
    
//     @Autowired
//     private AuthenticationManager authenticationManager;
    
//     @PostMapping("/login")
//     public ResponseEntity login(@RequestBody @Valid authenticationDTO date) {
//         var usernamePassword = new usernamePasswordAuthenticationToken(date.login(), date.password());
//         var auth = this.authenticationManager.authenticate(usernamePassword);
//     } 
// }
