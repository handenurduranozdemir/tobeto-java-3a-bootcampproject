package com.tobeto.bootcampProject.business.requests.update;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampStateRequest {
    @NotEmpty(message = "Bootcamp State ID must not be null")
    private int id;

    @NotEmpty(message = "State must not be null")
    private String status;
}
