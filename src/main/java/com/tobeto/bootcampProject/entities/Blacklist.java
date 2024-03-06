package com.tobeto.bootcampProject.entities;

import com.tobeto.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "Blacklists")
public class Blacklist extends BaseEntity<Integer> {
    @Column(name = "reason")
    private String reason;

    @Column(name = "date")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
}