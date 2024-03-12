package com.tobeto.bootcampProject.business.requests.update;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationRequest {
    @NotEmpty(message = "Application ID must not be null")
    private int id;

    @NotEmpty(message = "Applicant ID must not be null")
    private int applicantId;

    @NotEmpty(message = "Bootcamp ID must not be null")
    private int bootcampId;

    @NotEmpty(message = "Application State ID must not be null")
    private int applicationStateId;
}
