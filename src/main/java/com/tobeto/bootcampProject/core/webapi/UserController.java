package com.tobeto.bootcampProject.core.webapi;

import com.tobeto.bootcampProject.business.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController extends BaseController {
    private UserService userService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAllUsers()
    {
        return handleDataResult(userService.getAll());
    }

    @GetMapping("/getbyemail/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email)
    {
        return handleDataResult(userService.getByEmail(email));
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id)
    {
        return handleDataResult(userService.getById(id));
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(int id){
        return handleResult(userService.delete(id);
    }*/
}
