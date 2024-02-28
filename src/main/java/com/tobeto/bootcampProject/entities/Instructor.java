package com.tobeto.bootcampProject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Instructors")
@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "user_id")

public class Instructor extends User {

    @Column(name = "companyName")
    private String companyName;

    @OneToMany(mappedBy = "instructor")
    private List<Bootcamp> bootcamps;
}
