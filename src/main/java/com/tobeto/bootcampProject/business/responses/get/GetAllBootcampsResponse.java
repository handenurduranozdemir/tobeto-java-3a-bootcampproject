package com.tobeto.bootcampProject.business.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBootcampsResponse {
    private int id;
    private String name;
    private int instructorId;
    private String instructorFirstName;
    private String instructorLastName;
}
