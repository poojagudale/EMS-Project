package com.gpm.ems.repository;

import com.gpm.ems.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    Optional<Login> findByUsernameAndPassword(String username, String password);
}

