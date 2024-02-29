package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.CreateApplicationRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateApplicationRequest;
import com.tobeto.bootcampProject.business.responses.create.CreateApplicationResponse;
import com.tobeto.bootcampProject.business.responses.get.GetAllApplicationsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdApplicationResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateApplicationResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;

import java.util.List;

public interface ApplicationService {
    DataResult<List<GetAllApplicationsResponse>> getAll();
    DataResult<GetByIdApplicationResponse> getByID(int id);
    DataResult<CreateApplicationResponse> add(CreateApplicationRequest applicationRequest);
    DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest applicationRequest, int id);
    Result delete(int id);
}
