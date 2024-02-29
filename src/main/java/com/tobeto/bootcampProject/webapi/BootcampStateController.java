package com.tobeto.bootcampProject.webapi;

import com.tobeto.bootcampProject.business.abstracts.BootcampStateService;
import com.tobeto.bootcampProject.business.requests.create.CreateBootcampStateRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateBootcampStateRequest;
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
     public ResponseEntity<?> add(@RequestBody CreateBootcampStateRequest bootcampStateRequest){
        return handleDataResult(bootcampStateService.add(bootcampStateRequest));
    }

    @GetMapping("/{id}")
     public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(bootcampStateService.getById(id));
    }

    @PutMapping("/{id}")
     public ResponseEntity<?> update(UpdateBootcampStateRequest bootcampStateRequest, int id) {
        return handleDataResult(bootcampStateService.update(bootcampStateRequest, id));
    }

    @DeleteMapping("/{id}")
     public ResponseEntity<?> delete(int id){
        return handleResult(bootcampStateService.delete(id));
    }
}
