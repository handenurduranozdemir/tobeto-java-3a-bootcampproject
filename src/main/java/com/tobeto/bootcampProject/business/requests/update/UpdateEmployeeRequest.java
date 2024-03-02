package com.tobeto.bootcampProject.business.requests.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private String position;
    private String dateOfBirth;
    private String nationalIdentity;
    private String email;
}
