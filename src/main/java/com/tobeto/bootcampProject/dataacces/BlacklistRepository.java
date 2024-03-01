package com.tobeto.bootcampProject.dataacces;

import com.tobeto.bootcampProject.entities.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlacklistRepository extends JpaRepository<Blacklist, Integer> {
}