package com.tobeto.bootcampProject.business.responses.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationResponse {
    private int id;
    private int applicantId;
    private String applicantFirstName;
    private String applicantLastName;
    private int bootcampId;
    private String BootcampName;
    private int applicationStateId;
    private String applicationStateStatus;
}
