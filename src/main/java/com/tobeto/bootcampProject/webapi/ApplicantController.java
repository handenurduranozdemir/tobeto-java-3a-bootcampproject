package com.tobeto.bootcampProject.webapi;

import com.tobeto.bootcampProject.business.abstracts.ApplicantService;
import com.tobeto.bootcampProject.business.requests.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.UpdateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.GetAllApplicantsResponse;
import com.tobeto.bootcampProject.business.responses.GetByIdApplicantResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantController {
    private ApplicantService applicantService;

    @RequestMapping("/getall")
    public List<GetAllApplicantsResponse> findAll()
    {
        return applicantService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdApplicantResponse getById(@PathVariable int id)
    {
        return applicantService.getById(id);
    }
    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public  void add(@RequestBody() CreateApplicantRequest applicantRequest)
    {
        applicantService.add(applicantRequest);
    }
    @PutMapping
    public void update(@RequestBody() UpdateApplicantRequest updateApplicantRequest)
    {
        applicantService.update(updateApplicantRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        applicantService.delete(id);
    }

}