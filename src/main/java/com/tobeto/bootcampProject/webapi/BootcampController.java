package com.tobeto.bootcampProject.webapi;

import com.tobeto.bootcampProject.business.abstracts.BootcampService;
import com.tobeto.bootcampProject.business.requests.create.CreateBootcampRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateBootcampRequest;
import jakarta.validation.Valid;
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
    public ResponseEntity<?> add(@RequestBody @Valid CreateBootcampRequest bootcampRequest) {
        return handleDataResult(bootcampService.add(bootcampRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return handleDataResult(bootcampService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateBootcampRequest bootcampRequest){
        return handleDataResult(bootcampService.update(bootcampRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return handleResult(bootcampService.delete(id));
    }
}