package com.tobeto.bootcampProject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employees")
@Data
@EqualsAndHashCode(callSuper = true)
@Entity


public class Employee extends User<Long>{
    @Column(name = "position")
    private String position;


}
