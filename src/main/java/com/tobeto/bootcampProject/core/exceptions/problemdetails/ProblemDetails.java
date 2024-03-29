package com.tobeto.bootcampProject.core.exceptions.problemdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemDetails {
    private String title;
    private String detail;
    private String status;
    private String type;
}