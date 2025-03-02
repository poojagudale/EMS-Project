package com.gpm.ems.service;

import com.gpm.ems.dto.SalaryDto;

import java.time.LocalDate;
import java.util.List;

public interface SalaryService {
    SalaryDto createSalary(SalaryDto salaryDto);
    List<SalaryDto> getAllSalaries();
    List<SalaryDto> getSalariesByEmployeeId(Long employeeId);
    SalaryDto updateSalary(Long employeeId, SalaryDto salaryDto);
    void deleteSalary(Long employeeId);
    SalaryDto getSalaryByEmployeeIdAndDate(Long employeeId, LocalDate chooseDate);
    List<SalaryDto> getMonthlySalary(Long employeeId, LocalDate startDate, LocalDate endDate);
}
