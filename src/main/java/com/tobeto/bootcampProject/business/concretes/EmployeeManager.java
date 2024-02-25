package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.EmployeeService;
import com.tobeto.bootcampProject.business.requests.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.UpdateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.GetAllEmployeesResponse;
import com.tobeto.bootcampProject.business.responses.GetByIdEmployeeResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.EmployeeRepository;
import com.tobeto.bootcampProject.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllEmployeesResponse> getAll() {
        List<Employee> employees=employeeRepository.findAll();
        List<GetAllEmployeesResponse> getAllEmployeeResponses=employees.stream()
                .map(employee->modelMapperService.forResponse()
                        .map(employee, GetAllEmployeesResponse.class)).collect(Collectors.toList());

        return getAllEmployeeResponses;
    }

    @Override
    public GetByIdEmployeeResponse getById(int id) {
        Employee employee=employeeRepository.findById(id).orElseThrow();
        GetByIdEmployeeResponse response=modelMapperService.forResponse()
                .map(employee,GetByIdEmployeeResponse.class);
        return response;
    }

    @Override
    public void add(CreateEmployeeRequest employeeRequest) {
        Employee employee=modelMapperService.forRequest().map(employeeRequest,Employee.class);//mapped
        this.employeeRepository.save(employee);
    }

    @Override
    public void update(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee=modelMapperService.forRequest().map(updateEmployeeRequest,Employee.class);//mapped
        this.employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
