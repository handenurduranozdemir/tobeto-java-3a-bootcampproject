package com.tobeto.bootcampProject.webapi;

import com.tobeto.bootcampProject.business.abstracts.BootcampStateService;
import com.tobeto.bootcampProject.business.requests.create.CreateBootcampStateRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateBootcampStateRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bootcampstates")
@AllArgsConstructor
public class BootcampStateController extends BaseController{
    private BootcampStateService bootcampStateService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return handleDataResult(bootcampStateService.getAll());
    }

    @PostMapping("/create")
     public ResponseEntity<?> add(@RequestBody @Valid CreateBootcampStateRequest bootcampStateRequest){
        return handleDataResult(bootcampStateService.add(bootcampStateRequest));
    }

    @GetMapping("/{id}")
     public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(bootcampStateService.getById(id));
    }

    @PutMapping("/{id}")
     public ResponseEntity<?> update(@RequestBody @Valid UpdateBootcampStateRequest bootcampStateRequest) {
        return handleDataResult(bootcampStateService.update(bootcampStateRequest));
    }

    @DeleteMapping("/{id}")
     public ResponseEntity<?> delete(@PathVariable int id){
        return handleResult(bootcampStateService.delete(id));
    }
}