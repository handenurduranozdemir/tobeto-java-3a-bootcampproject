package com.tobeto.bootcampProject.business.requests.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
    private String position;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String nationalIdentity;
}
