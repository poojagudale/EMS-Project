package com.gpm.ems.mapper;

import com.gpm.ems.dto.SalaryDto;
import com.gpm.ems.entity.Salary;

public class SalaryMapper {
    public static SalaryDto mapToSalaryDto(Salary salary) {
        return new SalaryDto(
                salary.getEmployeeId(),
                salary.getChooseDate(),
                salary.getCloth(),
                salary.getSalary()
        );
    }

    public static Salary mapToSalary(SalaryDto salaryDto) {
        return new Salary(
                salaryDto.getEmployeeId(),
                salaryDto.getChooseDate(),
                salaryDto.getCloth(),
                salaryDto.getSalary()
        );
    }
}
