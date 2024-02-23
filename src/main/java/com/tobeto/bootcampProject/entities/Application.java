package com.tobeto.bootcampProject.entities;

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
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "applicant_id")
    private int applicantId;
    @Column(name = "bootcamp_id")
    private int bootcampId;
    @Column(name = "application_state_id")
    private int applicationStateId;
}
