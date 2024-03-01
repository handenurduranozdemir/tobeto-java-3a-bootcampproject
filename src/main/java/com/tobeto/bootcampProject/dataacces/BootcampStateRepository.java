package com.tobeto.bootcampProject.dataacces;

import com.tobeto.bootcampProject.entities.BootcampState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampStateRepository extends JpaRepository<BootcampState, Integer> {
}