package com.gpm.ems.repository;

import com.gpm.ems.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SalaryRepository extends JpaRepository<Salary, Long> {

    Optional<Salary> findByEmployeeIdAndChooseDate(Long employeeId, LocalDate chooseDate);

    @Query("SELECT s FROM Salary s WHERE s.employeeId = :employeeId AND s.chooseDate BETWEEN :startDate AND :endDate")
    List<Salary> findSalariesByEmployeeIdAndDateRange(
            @Param("employeeId") Long employeeId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
