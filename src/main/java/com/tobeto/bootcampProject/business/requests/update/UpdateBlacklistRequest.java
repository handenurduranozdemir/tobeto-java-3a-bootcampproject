package com.tobeto.bootcampProject.business.requests.update;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlacklistRequest {
    @NotEmpty(message = "Blacklist ID must not be empty")
    private int id;

    @NotEmpty(message = "Reason name must not be empty")
    private String reason;

    @NotEmpty(message = "Date name must not be empty")
    private LocalDate date;

    @NotEmpty(message = "Applicant ID name must not be empty")
    private int applicantId;
}
