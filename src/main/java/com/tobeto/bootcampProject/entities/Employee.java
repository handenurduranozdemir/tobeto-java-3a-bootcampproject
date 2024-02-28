package com.tobeto.bootcampProject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employees")
@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "user_id")


public class Employee extends User {
    /*@ManyToOne
    @JoinColumn(name = "employee_id")
    private User employee;*/

    @Column(name = "position")
    private String position;

}
