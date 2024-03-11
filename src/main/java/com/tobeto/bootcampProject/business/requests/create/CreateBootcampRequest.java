package com.tobeto.bootcampProject.business.requests.create;

import com.tobeto.bootcampProject.entities.BootcampState;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampRequest {
    @NotEmpty(message = "Bootcamp name must not be empty")
    private String name;

    @NotEmpty(message = "Instructor ID must not be null")
    private int instructorId;

    @NotEmpty(message = "Start date must not be null")
    private LocalDate startDate;

    @NotEmpty(message = "End date must not be null")
    private LocalDate endDate;

    @NotEmpty(message = "Bootcamp state ID must not be null")
    private int bootcampStateId;
}
