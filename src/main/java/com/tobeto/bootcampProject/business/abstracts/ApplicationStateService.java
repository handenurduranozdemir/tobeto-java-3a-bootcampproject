package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.CreateApplicationStateRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateApplicationStateRequest;
import com.tobeto.bootcampProject.business.responses.create.CreateApplicationStateResponse;
import com.tobeto.bootcampProject.business.responses.get.GetAllApplicationStatesResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdApplicationStateResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateApplicationStateResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;

import java.util.List;

public interface ApplicationStateService {
    DataResult<List<GetAllApplicationStatesResponse>> getAll();
    DataResult<GetByIdApplicationStateResponse> getById(int id);
    DataResult<CreateApplicationStateResponse> add(CreateApplicationStateRequest applicationStateRequest);
    DataResult<UpdateApplicationStateResponse> update(UpdateApplicationStateRequest applicationStateRequest, int id);
    Result delete(int id);
}
