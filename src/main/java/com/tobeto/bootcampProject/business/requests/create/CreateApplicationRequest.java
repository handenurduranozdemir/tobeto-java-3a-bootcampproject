package com.tobeto.bootcampProject.business.requests.create;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationRequest {
    @NotEmpty(message = "Applicant ID must not be null")
    private int applicantId;

    @NotEmpty(message = "Bootcamp ID must not be null")
    private int bootcampId;

    @NotEmpty(message = "Application State ID must not be null")
    private int applicationStateId;
}
