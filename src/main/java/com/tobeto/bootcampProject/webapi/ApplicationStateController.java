package com.tobeto.bootcampProject.webapi;

import com.tobeto.bootcampProject.business.abstracts.ApplicationStateService;
import com.tobeto.bootcampProject.business.requests.create.CreateApplicationStateRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateApplicationStateRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applicationstates")
@AllArgsConstructor
public class ApplicationStateController extends BaseController{
    private ApplicationStateService applicationStateService;

    @GetMapping("/getall")
    public ResponseEntity<?> findAll()
    {
        return handleDataResult(applicationStateService.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?> add(@RequestBody @Valid CreateApplicationStateRequest applicationStateRequest){
        return handleDataResult(applicationStateService.add(applicationStateRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateApplicationStateRequest applicationStateRequest){
        return handleDataResult(applicationStateService.update(applicationStateRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(applicationStateService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return handleResult(applicationStateService.delete(id));
    }
}