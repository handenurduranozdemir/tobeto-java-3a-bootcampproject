package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.get.GetAllApplicantsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdApplicantResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateApplicantResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;

import java.util.List;

public interface ApplicantService {
    DataResult<List<GetAllApplicantsResponse>> getAll();
    DataResult<GetByIdApplicantResponse> getById(int id);
    void add(CreateApplicantRequest applicantRequest);
    DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest, int id);
    Result delete(int id);

}
