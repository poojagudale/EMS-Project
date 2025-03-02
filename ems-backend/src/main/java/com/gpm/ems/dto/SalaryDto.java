package com.gpm.ems.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDto {
    private Long employeeId;
    private LocalDate chooseDate;
    private Integer cloth;
    private Double salary;
}
