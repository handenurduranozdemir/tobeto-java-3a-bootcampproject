package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.get.GetAllEmployeesResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdEmployeeResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;

import java.util.List;

public interface EmployeeService {
    DataResult<List<GetAllEmployeesResponse>> getAll();
    DataResult<GetByIdEmployeeResponse> getById(int id);
    void add(CreateEmployeeRequest employeeRequest);
    DataResult update(UpdateEmployeeRequest updateEmployeeRequest);
    Result delete(int id);
}
