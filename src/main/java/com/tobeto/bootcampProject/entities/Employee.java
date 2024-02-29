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

    @Column(name = "position")
    private String position;

}
