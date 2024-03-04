package com.tobeto.bootcampProject.business.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllApplicationsResponse {
    private int id;
    private int applicantId;
    private int bootcampId;
    private int getApplicantId;
}
