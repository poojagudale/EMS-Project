package com.gpm.ems.controller;



import com.gpm.ems.entity.Login;
import com.gpm.ems.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public String login(@RequestBody Login login) {
        Optional<Login> user = loginService.validateLogin(login.getUsername(), login.getPassword());
        if (user.isPresent()) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }
}

