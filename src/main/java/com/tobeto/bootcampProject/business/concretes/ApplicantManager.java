package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.ApplicantService;
import com.tobeto.bootcampProject.business.requests.create.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.get.GetAllApplicantsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetAllEmployeesResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdApplicantResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateApplicantResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateEmployeeResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;
import com.tobeto.bootcampProject.core.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.results.SuccessResult;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.ApplicantRepository;
import com.tobeto.bootcampProject.dataacces.EmployeeRepository;
import com.tobeto.bootcampProject.entities.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

    private ApplicantRepository applicantRepository;
    private ModelMapperService modelMapperService;
    private final EmployeeRepository employeeRepository;

    @Override
    public DataResult<List<GetAllApplicantsResponse>> getAll() {
        List<Applicant> applicants = applicantRepository.findAll();

        List<GetAllApplicantsResponse> responses = applicants.stream()
                .map(applicant->modelMapperService.forResponse()
                        .map(applicant, GetAllApplicantsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllApplicantsResponse>>(responses, "All applicants are listed");
    }

    @Override
    public DataResult<GetByIdApplicantResponse> getById(int id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow();
        GetByIdApplicantResponse response = modelMapperService.forResponse()
                .map(applicant, GetByIdApplicantResponse.class);
        return new SuccessDataResult<GetByIdApplicantResponse>(response, "Applicant is listed");
    }

    @Override
    public void add(CreateApplicantRequest applicantRequest) {
        Applicant applicant = modelMapperService.forRequest().map(applicantRequest,Applicant.class);
        this.applicantRepository.save(applicant);
    }


    public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest applicantRequest, int id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow();
        Applicant updatedApplicant = modelMapperService.forRequest().map(applicantRequest,Applicant.class);

        applicant.setId(id);
        applicant.setUpdatedDate(LocalDateTime.now());
        applicant.setFirstName(updatedApplicant.getFirstName());
        applicant.setLastName(updatedApplicant.getLastName());
        applicant.setUsername(updatedApplicant.getUsername());
        applicant.setNationalIdentity(updatedApplicant.getNationalIdentity());
        applicant.setDateOfBirth(updatedApplicant.getDateOfBirth());
        applicant.setEmail(updatedApplicant.getEmail());
        applicant.setAbout(updatedApplicant.getAbout());

        applicantRepository.save(applicant);
        UpdateApplicantResponse response = modelMapperService.forResponse().map(applicant, UpdateApplicantResponse.class);

        return new SuccessDataResult<UpdateApplicantResponse>(response, "Applicant updated");
    }

    @Override
    public Result delete(int id) {
        applicantRepository.deleteById(id);
        return new SuccessResult("Applicant deleted");
    }
}

