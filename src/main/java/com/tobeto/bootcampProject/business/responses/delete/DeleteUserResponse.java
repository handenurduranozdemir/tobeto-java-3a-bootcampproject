package com.tobeto.bootcampProject.business.responses.delete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteUserResponse {
    private int id;
    private String message;
    private String name;
}
