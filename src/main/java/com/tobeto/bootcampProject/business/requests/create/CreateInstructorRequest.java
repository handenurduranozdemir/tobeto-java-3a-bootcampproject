package com.tobeto.bootcampProject.business.requests.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorRequest {
    private String companyName;
    private String username;
    private String firstName;
    private String lastName;
}
