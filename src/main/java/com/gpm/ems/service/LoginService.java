package com.gpm.ems.service;


import com.gpm.ems.entity.Login;
import com.gpm.ems.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Optional<Login> validateLogin(String username, String password) {
        return loginRepository.findByUsernameAndPassword(username, password);
    }
}

