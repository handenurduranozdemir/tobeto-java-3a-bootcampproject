package com.tobeto.bootcampProject.entities;

import com.tobeto.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Bootcamp_States")
public class BootcampState extends BaseEntity<Integer> {

    @OneToMany(mappedBy = "bootcampState")
    private List<Bootcamp> bootcampList;

    @Column(name = "status")
    private String status;
}