package com.tobeto.bootcampProject.business.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdUserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String nationalIdentity;
    private String dateOfBirth;
}