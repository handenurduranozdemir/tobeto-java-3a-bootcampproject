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
public class Application extends BaseEntity<Long> {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;*/
    @ManyToOne
    //@Column(name = "applicant_id")
    @JoinColumn(name = "applicant_id")
    private User applicant;

    @ManyToOne
    //@Column(name = "bootcamp_id")
    @JoinColumn(name = "bootcamp_id")
    private Bootcamp bootcamp;

    @ManyToOne
    //@Column(name = "application_state_id")
    @JoinColumn(name = "application_state_id")
    private ApplicationState applicationState;
}
