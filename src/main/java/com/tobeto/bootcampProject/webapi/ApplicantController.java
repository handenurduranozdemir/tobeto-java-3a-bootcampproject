package com.tobeto.bootcampProject.webapi;

import com.tobeto.bootcampProject.business.abstracts.ApplicantService;
import com.tobeto.bootcampProject.business.requests.create.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateApplicantRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantController extends BaseController{
    private ApplicantService applicantService;

    @GetMapping("/getall")
    public ResponseEntity<?> findAll()
    {
        return handleDataResult(applicantService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id)
    {
        return handleDataResult(applicantService.getById(id));
    }
    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public ResponseEntity<?> add(@RequestBody @Valid CreateApplicantRequest applicantRequest)
    {
        return handleDataResult(applicantService.add(applicantRequest));
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid UpdateApplicantRequest updateApplicantRequest)
    {
        return handleDataResult(applicantService.update(updateApplicantRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id)
    {
        return handleResult(applicantService.delete(id));
    }
}