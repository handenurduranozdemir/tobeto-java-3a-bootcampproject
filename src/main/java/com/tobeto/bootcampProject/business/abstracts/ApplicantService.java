package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.get.GetAllApplicantsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdApplicantResponse;

import java.util.List;

public interface ApplicantService {
    List<GetAllApplicantsResponse> getAll();
    GetByIdApplicantResponse getById(int id);
    void add(CreateApplicantRequest applicantRequest);
    void update(UpdateApplicantRequest updateApplicantRequest);
    void delete(int id);

}
