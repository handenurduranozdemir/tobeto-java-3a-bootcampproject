package com.tobeto.bootcampProject.core.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity <T>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="createdDate")
    private LocalDateTime createdDate;

    @Column(name="updatedDate")
    private LocalDateTime updatedDate;

    @Column(name="deletedDate")
    private LocalDateTime deletedDate;

    @PrePersist
    private void prePersist(){
        this.createdDate=LocalDateTime.now();
    }
    @PreUpdate
    private void preUpdate(){
        this.updatedDate=LocalDateTime.now();

        // Sadece güncellenirken createdDate'i değiştirme
        if (this.createdDate == null) {
            this.createdDate = LocalDateTime.now();
        }

    }
}