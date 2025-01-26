package com.gpm.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
        private String dateOfBirth;

}
