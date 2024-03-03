package com.tobeto.bootcampProject.business.responses.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String companyName;
    private String nationalIdentity;
}
