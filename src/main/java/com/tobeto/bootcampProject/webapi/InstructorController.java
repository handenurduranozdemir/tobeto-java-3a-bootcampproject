package com.tobeto.bootcampProject.webapi;

import com.tobeto.bootcampProject.business.abstracts.InstructorService;
import com.tobeto.bootcampProject.business.requests.create.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateInstructorRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/instructors")
public class InstructorController extends BaseController{
    private InstructorService instructorService;

    @GetMapping("/getall")
    public ResponseEntity<?> findAll()
    {
        return handleDataResult(instructorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id)
    {
        return handleDataResult(instructorService.getById(id));
    }
    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public ResponseEntity<?> add(@RequestBody @Valid CreateInstructorRequest instructorRequest)
    {
        return handleDataResult(instructorService.add(instructorRequest));
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid UpdateInstructorRequest updateInstructorRequest){
        return handleDataResult(instructorService.update(updateInstructorRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return handleResult(instructorService.delete(id));
    }
}