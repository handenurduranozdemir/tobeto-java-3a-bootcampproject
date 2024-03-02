package com.tobeto.bootcampProject.business.requests.create;

import com.tobeto.bootcampProject.entities.BootcampState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampRequest {
    private String name;
    private int instructorId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int bootcampStateId;
}
