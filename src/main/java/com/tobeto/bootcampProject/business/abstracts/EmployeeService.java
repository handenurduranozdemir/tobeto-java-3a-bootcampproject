package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.UpdateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.GetAllEmployeesResponse;
import com.tobeto.bootcampProject.business.responses.GetByIdEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<GetAllEmployeesResponse> getAll();
    GetByIdEmployeeResponse getById(int id);
    void add(CreateEmployeeRequest employeeRequest);
    void update(UpdateEmployeeRequest updateEmployeeRequest);
    void delete(int id);
}
