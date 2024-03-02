package com.tobeto.bootcampProject.webapi;

import com.tobeto.bootcampProject.business.abstracts.BlacklistService;
import com.tobeto.bootcampProject.business.requests.create.CreateBlacklistRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateBlacklistRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blacklists")
@AllArgsConstructor
public class BlacklistController extends BaseController{
    private BlacklistService blacklistService;

    @GetMapping("/getall")
    public ResponseEntity<?> findAll(){
        return handleDataResult(blacklistService.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?> add(@RequestBody CreateBlacklistRequest blacklistRequest) {
        return handleDataResult(blacklistService.add(blacklistRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(blacklistService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(UpdateBlacklistRequest blacklistRequest, int id){
        return handleDataResult(blacklistService.update(blacklistRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return handleResult(blacklistService.delete(id));
    }
}