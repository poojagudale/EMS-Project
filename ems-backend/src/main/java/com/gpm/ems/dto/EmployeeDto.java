package com.gpm.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String mobileNumber;
        private String address;
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate dateOfJoining;
}
