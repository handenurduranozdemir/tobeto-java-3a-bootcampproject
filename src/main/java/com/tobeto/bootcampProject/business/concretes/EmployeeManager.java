package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.EmployeeService;
import com.tobeto.bootcampProject.business.requests.create.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.get.GetAllEmployeesResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateEmployeeResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;
import com.tobeto.bootcampProject.core.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.results.SuccessResult;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.EmployeeRepository;
import com.tobeto.bootcampProject.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllEmployeesResponse>> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployeesResponse> responses = employees.stream()
                .map(employee->modelMapperService.forResponse()
                        .map(employee, GetAllEmployeesResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllEmployeesResponse>>(responses, "All employees are listed");
    }

    @Override
    public DataResult<GetByIdEmployeeResponse> getById(int id) {
        Employee employee=employeeRepository.findById(id).orElseThrow();
        GetByIdEmployeeResponse response = modelMapperService.forResponse()
                .map(employee,GetByIdEmployeeResponse.class);

        return new SuccessDataResult<GetByIdEmployeeResponse>(response, "Employee is listed.");
    }

    @Override
    public void add(CreateEmployeeRequest employeeRequest) {
        Employee employee=modelMapperService.forRequest().map(employeeRequest,Employee.class);//mapped

        this.employeeRepository.save(employee);
    }

    @Override
    public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest, int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        Employee updatedEmployee=modelMapperService.forRequest().map(updateEmployeeRequest,Employee.class);

        employee.setId(id);
        employee.setUpdatedDate(LocalDateTime.now());
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setUsername(updatedEmployee.getUsername());
        employee.setNationalIdentity(updatedEmployee.getNationalIdentity());
        employee.setDateOfBirth(updatedEmployee.getDateOfBirth());
        employee.setPosition(updatedEmployee.getPosition());

        this.employeeRepository.save(employee);
        UpdateEmployeeResponse response = modelMapperService.forResponse().map(employee, UpdateEmployeeResponse.class);

        return new SuccessDataResult<UpdateEmployeeResponse>(response, "Empoloye updated");
    }

    @Override
    public Result delete(int id)
    {
        employeeRepository.deleteById(id);
        return new SuccessResult("Employee is deleted");
    }
}
