package com.tobeto.bootcampProject.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Instructors")
@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "user_id")

public class Instructor extends User {
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private User instructor;

    @Column(name = "companyName")
    private String companyName;
}
