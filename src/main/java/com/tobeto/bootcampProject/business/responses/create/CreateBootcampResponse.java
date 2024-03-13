package com.tobeto.bootcampProject.business.responses.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampResponse {
    private int id;
    private String name;
    private int instructorId;
    private String instructorFirstName;
    private String instructorLastName;
    private LocalDate startDate;
    private LocalDate endDate;
    private int bootcampStateId;
    private String bootcampStateStatus;
}
