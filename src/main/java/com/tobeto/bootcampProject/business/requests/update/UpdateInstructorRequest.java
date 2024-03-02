package com.tobeto.bootcampProject.business.requests.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInstructorRequest {
    private String username;
    private String firstName;
    private String lastName;
    private String companyName;
    private String email;
}
