package com.tobeto.bootcampProject.business.requests.create;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampStateRequest {
    @NotEmpty(message = "Bootcamp state must not be null")
    private String status;
}
