package com.tobeto.bootcampProject.business.requests.update;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationStateRequest {
    @NotEmpty(message = "Application state ID must not be null")
    private int id;

    @NotEmpty(message = "Application state must not be null")
    private int state;
}
