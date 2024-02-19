package com.tobeto.bootcampProject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Instructors")
@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "userid")

public class Instructor extends User {

    @Column(name = "companyName")
    private String companyName;
}
