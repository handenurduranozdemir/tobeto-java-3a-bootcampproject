package com.tobeto.bootcampProject.webapi;

import com.tobeto.bootcampProject.business.abstracts.EmployeeService;
import com.tobeto.bootcampProject.business.requests.create.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateEmployeeRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController extends BaseController {
    private EmployeeService employeeService;

    @RequestMapping("/getall")
    public ResponseEntity<?> findAll(){
        return handleDataResult(employeeService.getAll());
    }
    @GetMapping("/{id}")//variable al, pathden okur
    public ResponseEntity<?> getById(@PathVariable int id) {
        return handleDataResult(employeeService.getById(id));
    }
    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public  void add(@RequestBody() CreateEmployeeRequest employeeRequest){
        employeeService.add(employeeRequest);
    }
    @PutMapping
    public void update(@RequestBody() UpdateEmployeeRequest updateEmployeeRequest){
        employeeService.update(updateEmployeeRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        employeeService.delete(id);
    }
}
