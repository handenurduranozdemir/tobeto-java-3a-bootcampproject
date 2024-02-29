package com.tobeto.bootcampProject.business.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampResponse {
    private String name;
    private int instructor_id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int bootcampState_id;
}
