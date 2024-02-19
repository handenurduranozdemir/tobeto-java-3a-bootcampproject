package com.tobeto.bootcampProject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Applicants")
@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "userid")

public class Applicant extends User {

    @Column(name = "about")
    private String about;
}
