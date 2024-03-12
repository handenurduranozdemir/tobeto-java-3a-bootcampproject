package com.tobeto.bootcampProject.business.requests.update;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    @NotEmpty(message = "Employee ID must not be null")
    private int id;

    @NotEmpty(message = "First name must not be empty")
    @Size(min = 2, max = 50, message = "First name must be contain at least 2 characters")
    private String firstName;

    @NotEmpty(message = "Last name must not be empty")
    @Size(min = 2, max = 50, message = "Last name must be contain at least 2 characters")
    private String lastName;

    @NotEmpty(message = "username must not be empty")
    @Size(min = 2, max = 50, message = "Username must be contain at least 2 characters")
    private String userName;

    @NotEmpty(message = "National identity must be not empty")
    @Size(min = 11, max = 11, message = "National identity must be contain 11 characters")
    private String nationalIdentity;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Invalid email address")
    private String email;

    @NotNull(message = "Date of Birt must not be null")
    @Past(message = "Date of birth must be in the past")
    private String dateOfBirth;

    @NotEmpty(message = "Position must not be null")
    private String position;



}
