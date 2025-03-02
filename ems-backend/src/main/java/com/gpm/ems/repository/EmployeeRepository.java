package com.gpm.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gpm.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
