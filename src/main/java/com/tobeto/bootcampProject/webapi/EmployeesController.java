package com.tobeto.bootcampProject.webapi;

import com.tobeto.bootcampProject.dataacces.EmployeeRepository;
import com.tobeto.bootcampProject.entities.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    private EmployeeRepository employeeRepository;

    public EmployeesController(EmployeeRepository employeeRepository) {this.employeeRepository = employeeRepository;}

    @RequestMapping("/getall")
    public List<Employee> findAll() {return employeeRepository.findAll();}

    @RequestMapping("/add1")
    public void add() {
        Employee employee = new Employee();
        employee.setUsername("alpo");
        employee.setEmail("alpo@gmail.com");
        employee.setPosition("software developer");
        employeeRepository.save(employee);
    }
}
