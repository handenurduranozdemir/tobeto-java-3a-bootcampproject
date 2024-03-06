package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.EmployeeService;
import com.tobeto.bootcampProject.business.requests.create.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.create.CreateEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.GetAllEmployeesResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateEmployeeResponse;
import com.tobeto.bootcampProject.core.exceptions.types.BusinessException;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.EmployeeRepository;
import com.tobeto.bootcampProject.dataacces.UserRepository;
import com.tobeto.bootcampProject.entities.Employee;
import com.tobeto.bootcampProject.entities.User;
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
    private final UserRepository userRepository;

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
    public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest employeeRequest) {
        checkIfUserExist(employeeRequest.getNationalIdentity());
        Employee employee=modelMapperService.forRequest().map(employeeRequest,Employee.class);

        this.employeeRepository.save(employee);

        CreateEmployeeResponse response = modelMapperService.forResponse()
                .map(employee, CreateEmployeeResponse.class);

        return new SuccessDataResult<CreateEmployeeResponse> (response, "Employee is created");
    }

    @Override
    public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findById(employeeRequest.getId()).orElseThrow();
        Employee updatedEmployee=modelMapperService.forRequest().map(employeeRequest,Employee.class);

        employee.setUpdatedDate(LocalDateTime.now());
        employee.setFirstName(updatedEmployee.getFirstName() !=
                null ? updatedEmployee.getFirstName() : employee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName() !=
                null ? updatedEmployee.getLastName() : employee.getLastName());
        employee.setUsername(updatedEmployee.getUsername() !=
                null ? updatedEmployee.getUsername() : employee.getUsername());
        employee.setNationalIdentity(updatedEmployee.getNationalIdentity() !=
                null ? updatedEmployee.getNationalIdentity() : employee.getNationalIdentity());
        employee.setDateOfBirth(updatedEmployee.getDateOfBirth() !=
                null ? updatedEmployee.getDateOfBirth() : employee.getDateOfBirth());
        employee.setPosition(updatedEmployee.getPosition() !=
                null ? updatedEmployee.getPosition() : employee.getPosition());

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

    @Override
    public void checkIfUserExist(String nationalIdentity) {
        User employee = userRepository.findByNationalIdentity(nationalIdentity);
        if (employee != null)
            throw  new BusinessException("Employee is already created");
    }
}