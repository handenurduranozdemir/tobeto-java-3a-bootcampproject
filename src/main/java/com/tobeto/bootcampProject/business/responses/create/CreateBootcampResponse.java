package com.tobeto.bootcampProject.business.responses.create;

import com.tobeto.bootcampProject.entities.BootcampState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampResponse {
    private int id;
    private int instructor_id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BootcampState bootcampState;
}
