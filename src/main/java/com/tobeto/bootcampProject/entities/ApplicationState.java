package com.tobeto.bootcampProject.entities;

import com.tobeto.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ApplicationStates")
public class ApplicationState extends BaseEntity<Integer> {

    @OneToMany(mappedBy = "applicationState")
    private List<Application> applicationList;

    @Column(name = "state")
    private int state;
}