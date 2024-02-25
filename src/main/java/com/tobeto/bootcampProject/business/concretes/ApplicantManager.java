package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.ApplicantService;
import com.tobeto.bootcampProject.business.requests.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.UpdateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.GetAllApplicantsResponse;
import com.tobeto.bootcampProject.business.responses.GetByIdApplicantResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.ApplicantRepository;
import com.tobeto.bootcampProject.entities.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

    private ApplicantRepository applicantRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllApplicantsResponse> getAll() {
        List<Applicant> applicants = applicantRepository.findAll();

        List<GetAllApplicantsResponse> getAllApplicantResponses = applicants.stream()
                .map(applicant->modelMapperService.forResponse()
                        .map(applicant, GetAllApplicantsResponse.class)).collect(Collectors.toList());

        return getAllApplicantResponses;
    }

    @Override
    public GetByIdApplicantResponse getById(int id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow();//eğer id gelmezse orElse olmazsa optinal yazarız
        GetByIdApplicantResponse response = modelMapperService.forResponse()
                .map(applicant, GetByIdApplicantResponse.class);
        return response;
    }

    @Override
    public void add(CreateApplicantRequest applicantRequest) {
        Applicant applicant = modelMapperService.forRequest().map(applicantRequest,Applicant.class);
        this.applicantRepository.save(applicant);
    }


    public void update(UpdateApplicantRequest applicantRequest) {
        Applicant applicant = modelMapperService.forRequest().map(applicantRequest,Applicant.class);
        applicantRepository.save(applicant);
    }

    @Override
    public void delete(int id) {
        applicantRepository.deleteById(id);
    }


}

