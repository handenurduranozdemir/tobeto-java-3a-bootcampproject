package com.tobeto.bootcampProject.business.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlacklistResponse {
    private int id;
    private String reason;
    private LocalDate date;
    private int applicant_id;
    private String applicantFirstName;
    private String applicantLastName;
}
