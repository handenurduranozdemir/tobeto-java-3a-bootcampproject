package com.tobeto.bootcampProject.business.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String nationalIdentity;
    private String dateOfBirth;
    private String position;
}
