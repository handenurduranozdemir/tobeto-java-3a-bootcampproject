package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.create.CreateApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.GetAllApplicantsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdApplicantResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateApplicantResponse;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;

import java.util.List;

public interface ApplicantService {
    DataResult<List<GetAllApplicantsResponse>> getAll();
    DataResult<GetByIdApplicantResponse> getById(int id);
    DataResult<CreateApplicantResponse> add(CreateApplicantRequest applicantRequest);
    DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest);
    Result delete(int id);
    void checkIfUserExist(String nationalIdentity);
    DataResult<List<GetAllApplicantsResponse>> getAllSorted(PageDto pageDto);

}
