package com.gpm.ems.mapper;

import com.gpm.ems.dto.EmployeeDto;
import com.gpm.ems.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getMobileNumber(),
                employee.getAddress(),
                employee.getDateOfJoining()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getMobileNumber(),
                employeeDto.getAddress(),
                employeeDto.getDateOfJoining()
        );
    }
}
