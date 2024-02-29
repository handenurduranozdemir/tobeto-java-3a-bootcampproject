package com.tobeto.bootcampProject.business.responses.delete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteApplicantResponse {
    private String message;
    private int id;
    private String name;
}
