package com.tobeto.bootcampProject.dataacces;

import com.tobeto.bootcampProject.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}