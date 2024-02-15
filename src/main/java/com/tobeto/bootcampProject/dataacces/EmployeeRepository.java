package com.tobeto.bootcampProject.dataacces;

import com.tobeto.bootcampProject.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
