package com.tobeto.bootcampProject.dataacces;

import com.tobeto.bootcampProject.entities.ApplicationState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationStateRepository extends JpaRepository<ApplicationState, Integer> {
}
