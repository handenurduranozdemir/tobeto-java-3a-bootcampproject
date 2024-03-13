package com.tobeto.bootcampProject.business.requests.create;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationStateRequest {
    @NotEmpty(message = "Application state must not be null")
    private String status;
}
