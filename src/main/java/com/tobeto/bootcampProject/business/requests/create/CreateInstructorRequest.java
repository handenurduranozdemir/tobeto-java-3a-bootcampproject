package com.tobeto.bootcampProject.business.requests.create;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorRequest {
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

    @NotEmpty(message = "Company name must not be null")
    private String companyName;

    @NotEmpty(message = "Password must not be empty")
    @Size(min = 8, max = 30, message = "Password must be contain at least 8 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
            message = "Password must contain at least one lowercase character, " +
                    "one uppercase character and one number character")
    private String password;
}
