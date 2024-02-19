package com.tobeto.bootcampProject.webapi;

import com.tobeto.bootcampProject.business.abstracts.InstructorService;
import com.tobeto.bootcampProject.business.requests.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.requests.UpdateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.GetAllInstructorsResponse;
import com.tobeto.bootcampProject.business.responses.GetByIdInstructorResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Instructors")
public class InstructorController {

    private InstructorService instructorService;

    @RequestMapping("/getall")
    public List<GetAllInstructorsResponse> findAll(){
        return  instructorService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdInstructorResponse getById(@PathVariable int id) {
        return instructorService.getById(id);
    }
    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public  void add(@RequestBody() CreateInstructorRequest instructorRequest){
        instructorService.add(instructorRequest);
    }
    @PutMapping
    public void update(@RequestBody() UpdateInstructorRequest updateInstructorRequest){
        instructorService.update(updateInstructorRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        instructorService.delete(id);
    }

}

