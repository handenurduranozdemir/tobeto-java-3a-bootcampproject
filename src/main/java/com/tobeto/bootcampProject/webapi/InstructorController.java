package com.tobeto.bootcampProject.webapi;

import com.tobeto.bootcampProject.dataacces.InstructorRepository;
import com.tobeto.bootcampProject.entities.Instructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    private InstructorRepository instructorRepository;

    public InstructorController(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @RequestMapping("/getall")
    public List<Instructor> findAll() {return instructorRepository.findAll();}

    @RequestMapping("/add2")
    public void add() {
        Instructor instructor = new Instructor();
        instructor.setUsername("sare");
        instructor.setEmail("sare@gmail.com");
        instructor.setCompanyName("sareo");
        instructorRepository.save(instructor);
    }
}
