package com.tobeto.bootcampProject.business.responses.delete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteApplicationResponse {
    private int id;
    private String name;
    private String message;
}
