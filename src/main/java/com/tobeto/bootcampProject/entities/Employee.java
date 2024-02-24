package com.tobeto.bootcampProject.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employees")
@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "user_id")

public class Employee extends User {
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private User empployee;

    @Column(name = "position")
    private String position;
}
