package com.tobeto.bootcampProject.business.responses.update;

import com.tobeto.bootcampProject.entities.Application;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampResponse {
    private int id;
    private String name;
    private int instructorId;
    private String instructorFirstName;
    private String instructorLastName;
    private int bootcampStateId;
    private String bootcampStateStatus;
    private List<Application> applications;
}
