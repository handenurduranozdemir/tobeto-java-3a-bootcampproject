package com.tobeto.bootcampProject.entities;

import com.tobeto.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Applications")
public class Application extends BaseEntity<Integer> {

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bootcamp_id")
    private Bootcamp bootcamp;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "application_state_id")
    private ApplicationState applicationState;
}