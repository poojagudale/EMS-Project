package com.gpm.ems.controller;

import com.gpm.ems.dto.SalaryDto;
import com.gpm.ems.service.SalaryService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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

    @GetMapping("/{employeeId}/monthly")
    public Double getEmployeeMonthlySalary(
            @PathVariable Long employeeId,
            @RequestParam String startDate,
            @RequestParam String endDate
    ) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        Double totalSalary = salaryService.getMonthlySalary(employeeId, start, end);

        return totalSalary != null ? totalSalary : 0.0;
    }

    @GetMapping("/{employeeId}/monthly-cloth")
    public Integer getEmployeeMonthlyCloth(
            @PathVariable Long employeeId,
            @RequestParam String startDate,
            @RequestParam String endDate
    ) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        Integer totalCloth = salaryService.getTotalClothForMonth(employeeId, start, end);

        return totalCloth != null ? totalCloth : 0;
    }
}
