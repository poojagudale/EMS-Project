package com.gpm.ems.service.impl;

import com.gpm.ems.dto.SalaryDto;
import com.gpm.ems.entity.Salary;
import com.gpm.ems.mapper.SalaryMapper;
import com.gpm.ems.repository.SalaryRepository;
import com.gpm.ems.service.SalaryService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class SalaryServiceImpl implements SalaryService {

    private SalaryRepository salaryRepository;

    @Override
    @Transactional
    public SalaryDto createSalary(SalaryDto salaryDto) {
        Salary savedSalary = salaryRepository.save(SalaryMapper.mapToSalary(salaryDto));
        return SalaryMapper.mapToSalaryDto(savedSalary);
    }

    @Override
    public List<SalaryDto> getAllSalaries() {
        return salaryRepository.findAll().stream()
                .map(SalaryMapper::mapToSalaryDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SalaryDto> getSalariesByEmployeeId(Long employeeId) {
        return salaryRepository.findByEmployeeIdAndChooseDate(employeeId, LocalDate.now())
                .stream().map(SalaryMapper::mapToSalaryDto)
                .collect(Collectors.toList());
    }

    @Override
    public SalaryDto updateSalary(Long employeeId, SalaryDto salaryDto) {
        Salary existingSalary = salaryRepository.findByEmployeeIdAndChooseDate(employeeId, salaryDto.getChooseDate())
                .orElseThrow(() -> new RuntimeException("Salary not found"));

        existingSalary.setChooseDate(salaryDto.getChooseDate());
        existingSalary.setCloth(salaryDto.getCloth());
        existingSalary.setSalary(salaryDto.getSalary());

        Salary updatedSalary = salaryRepository.save(existingSalary);
        return SalaryMapper.mapToSalaryDto(updatedSalary);
    }

    @Override
    public void deleteSalary(Long employeeId) {
        salaryRepository.deleteById(employeeId);
    }

    @Override
    public SalaryDto getSalaryByEmployeeIdAndDate(Long employeeId, LocalDate chooseDate) {
        Optional<Salary> salary = salaryRepository.findByEmployeeIdAndChooseDate(employeeId, chooseDate);
        if (salary.isPresent()) {
            Salary s = salary.get();
            // ✅ Check if salary is not actually added yet
            if (s.getSalary() == null || s.getSalary() == 0.0) {
                return null;
            }
            return SalaryMapper.mapToSalaryDto(s);
        }
        return null;
    }

    @Override
    public Double getMonthlySalary(Long employeeId, LocalDate startDate, LocalDate endDate) {
        return salaryRepository.findSalariesByEmployeeIdAndDateRange(employeeId, startDate, endDate)
                .stream()
                .mapToDouble(Salary::getSalary)
                .sum();
    }

    @Override
    public Integer getTotalClothForMonth(Long employeeId, LocalDate startDate, LocalDate endDate) {
        return salaryRepository.getTotalClothForMonth(employeeId, startDate, endDate);
    }
}
