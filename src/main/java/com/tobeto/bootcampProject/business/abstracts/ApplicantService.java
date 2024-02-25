package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.UpdateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.GetAllApplicantsResponse;
import com.tobeto.bootcampProject.business.responses.GetByIdApplicantResponse;

import java.util.List;

public interface ApplicantService {
    List<GetAllApplicantsResponse> getAll();
    GetByIdApplicantResponse getById(int id);
    void add(CreateApplicantRequest applicantRequest);
    void update(UpdateApplicantRequest updateApplicantRequest);
    void delete(int id);

}
