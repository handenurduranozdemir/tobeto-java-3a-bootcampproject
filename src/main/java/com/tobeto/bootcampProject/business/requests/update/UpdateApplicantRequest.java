package com.tobeto.bootcampProject.business.requests.update;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicantRequest {
    @NotEmpty(message = "Applicant ID must not be empty")
    private int id;

    @NotEmpty(message = "First name must not be empty")
    @Size(min = 2, max = 50, message = "First name must be contain at least 2 characters")
    private String firstName;

    @NotEmpty(message = "Last name must not be empty")
    @Size(min = 2, max = 50, message = "Last name must be contain at least 2 characters")
    private String lastName;

    @NotEmpty(message = "Username must not be empty")
    @Size(min = 2, max = 50, message = "Username must be contain at least 2 characters")
    private String username;

    @NotEmpty(message = "National identity must be not empty")
    @Size(min = 11, max = 11, message = "National identity must be contain 11 characters")
    private String nationalIdentity;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Invalid email address")
    private String email;

    @NotNull(message = "Date of Birt must not be null")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotEmpty(message = "About must not be null")
    private String about;
}
