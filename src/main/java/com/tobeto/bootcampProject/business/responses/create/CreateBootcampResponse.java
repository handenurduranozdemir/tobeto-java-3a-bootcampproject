package com.tobeto.bootcampProject.business.responses.create;

import com.tobeto.bootcampProject.entities.BootcampState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampResponse {
    private int id;
    private int instructorId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private int bootcampStateId;
}
