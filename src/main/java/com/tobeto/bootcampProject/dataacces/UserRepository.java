package com.tobeto.bootcampProject.dataacces;

import com.tobeto.bootcampProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);
    User findByEmail(String email);
}