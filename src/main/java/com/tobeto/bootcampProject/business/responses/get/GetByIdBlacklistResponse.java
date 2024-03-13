package com.tobeto.bootcampProject.business.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdBlacklistResponse {
    private int id;
    private String reason;
    private LocalDate date;
    private int applicant_id;
    private String applicantFirstName;
    private String applicantLastName;
}
