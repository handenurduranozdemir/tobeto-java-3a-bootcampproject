package com.tobeto.bootcampProject.webapi;

import com.tobeto.bootcampProject.business.abstracts.BootcampService;
import com.tobeto.bootcampProject.business.requests.create.CreateBootcampRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateBootcampRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bootcamps")
@AllArgsConstructor
public class BootcampController extends BaseController {
    private BootcampService bootcampService;

    @GetMapping("/getall")
    public ResponseEntity<?> findAll() {
        return handleDataResult(bootcampService.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?> add(@RequestBody CreateBootcampRequest bootcampRequest) {
        return handleDataResult(bootcampService.add(bootcampRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return handleDataResult(bootcampService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(UpdateBootcampRequest bootcampRequest, int id){
        return handleDataResult(bootcampService.update(bootcampRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(int id) {
        return handleResult(bootcampService.delete(id));
    }
}