package com.tobeto.bootcampProject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Applicants")
@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "user_id")

public class Applicant extends User {

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private User applicant;

    @Column(name = "about")
    private String about;

    /*@OneToMany(mappedBy = "applicant")
    private List<Application> applications;*/
}
