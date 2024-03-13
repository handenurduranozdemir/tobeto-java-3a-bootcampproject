package com.tobeto.bootcampProject.business.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdApplicationResponse {
    private int id;
    private int applicantId;
    private String applicantFirstName;
    private String applicantLastName;
    private int bootcampId;
    private String bootcampName;
    private int applicationStateId;
    private String applicationStateStatus;
}
