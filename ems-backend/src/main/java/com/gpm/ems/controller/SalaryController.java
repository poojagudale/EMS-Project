package com.gpm.ems.controller;

import com.gpm.ems.dto.SalaryDto;
import com.gpm.ems.service.SalaryService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/salary")
public class SalaryController {

    private SalaryService salaryService;

    @PostMapping
    public ResponseEntity<SalaryDto> createSalary(@RequestBody SalaryDto salaryDto) {
        return ResponseEntity.ok(salaryService.createSalary(salaryDto));
    }

    @GetMapping("/{employeeId}/{chooseDate}")
    public ResponseEntity<SalaryDto> getSalaryByEmployeeIdAndDate(
            @PathVariable Long employeeId,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate chooseDate) {
        SalaryDto salaryDto = salaryService.getSalaryByEmployeeIdAndDate(employeeId, chooseDate);
        return salaryDto != null ? ResponseEntity.ok(salaryDto) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<SalaryDto> updateSalary(
            @PathVariable Long employeeId,
            @RequestBody SalaryDto salaryDto) {
        return ResponseEntity.ok(salaryService.updateSalary(employeeId, salaryDto));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteSalary(@PathVariable Long employeeId) {
        salaryService.deleteSalary(employeeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{employeeId}/range")
    public ResponseEntity<List<SalaryDto>> getMonthlySalary(
            @PathVariable Long employeeId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return ResponseEntity.ok(salaryService.getMonthlySalary(employeeId, startDate, endDate));
    }
}
