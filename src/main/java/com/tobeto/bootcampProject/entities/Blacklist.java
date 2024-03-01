package com.tobeto.bootcampProject.entities;

import com.tobeto.bootcampProject.core.entities.BaseEntity;
import com.tobeto.bootcampProject.webapi.BaseController;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private LocalDateTime date;

    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "applicant_id")
    private Applicant applicant;
}
