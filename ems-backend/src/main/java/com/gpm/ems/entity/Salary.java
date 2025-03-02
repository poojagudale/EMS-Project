package com.gpm.ems.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "salary")
public class Salary {

    @Id
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "chosen_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate chooseDate;

    @Column(name = "cloth_in_m", nullable = false)
    private Integer cloth;

    @Column(name = "salary", nullable = false)
    private Double salary;
}
