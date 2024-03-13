package com.tobeto.bootcampProject.business.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployeesResponse {
    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String nationalIdentity;
    private String dateOfBirth;
    private String position;
}
