package com.tobeto.bootcampProject.business.requests.update;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampRequest {
    @NotEmpty(message = "Bootcamp ID must not be null")
    private int id;

    @NotEmpty(message = "Bootcamp name must not be empty")
    private String name;

    @NotEmpty(message = "Instructor ID must not be null")
    private int instructorId;

    @NotEmpty(message = "Start date must not be null")
    private LocalDateTime startDate;

    @NotEmpty(message = "End date must not be null")
    private LocalDateTime endDate;

    @NotEmpty(message = "Bootcamp state ID must not be null")
    private int bootcampStateId;
}
