package com.tobeto.bootcampProject.core.webapi;

import com.tobeto.bootcampProject.business.abstracts.ApplicationService;
import com.tobeto.bootcampProject.business.requests.create.CreateApplicationRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateApplicationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
public class ApplicationController extends BaseController {
    private ApplicationService applicationService;

    @GetMapping("/getall")
    public ResponseEntity<?> findAll()
    {
        return handleDataResult(applicationService.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?> add(@RequestBody CreateApplicationRequest applicationRequest) {
        return handleDataResult(applicationService.add(applicationRequest));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(applicationService.getByID(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(UpdateApplicationRequest applicationRequest, int id) {
        return handleDataResult(applicationService.update(applicationRequest,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(int id){
        return handleResult(applicationService.delete(id));
    }
}
