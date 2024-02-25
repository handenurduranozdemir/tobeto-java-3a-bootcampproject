package com.tobeto.bootcampProject.webapi;

import com.tobeto.bootcampProject.business.abstracts.EmployeeService;
import com.tobeto.bootcampProject.business.requests.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.UpdateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.GetAllEmployeesResponse;
import com.tobeto.bootcampProject.business.responses.GetByIdEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;


    @RequestMapping("/getall")
    public List<GetAllEmployeesResponse> findAll(){
        return  employeeService.getAll();
    }
    @GetMapping("/{id}")//variable al, pathden okur
    public GetByIdEmployeeResponse getById(@PathVariable int id) {
        return employeeService.getById(id);
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
