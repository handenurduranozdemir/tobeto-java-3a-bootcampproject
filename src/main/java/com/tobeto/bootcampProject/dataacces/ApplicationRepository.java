package com.tobeto.bootcampProject.dataacces;

import com.tobeto.bootcampProject.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository <Application, Integer> {
}
