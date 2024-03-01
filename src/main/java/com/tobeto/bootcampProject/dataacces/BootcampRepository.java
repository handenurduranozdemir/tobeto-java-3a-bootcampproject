package com.tobeto.bootcampProject.dataacces;

import com.tobeto.bootcampProject.entities.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampRepository extends JpaRepository<Bootcamp, Integer> {
}