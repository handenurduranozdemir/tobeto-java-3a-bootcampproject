package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.CreateApplicationStateRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateApplicationStateRequest;
import com.tobeto.bootcampProject.business.responses.get.GetAllApplicationStatesResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdApplicationStateResponse;

import java.util.List;

public interface ApplicationStateService {
    List<GetAllApplicationStatesResponse> getAll();
    GetByIdApplicationStateResponse getById(int id);
    void add(CreateApplicationStateRequest applicationStateRequest);
    void update(UpdateApplicationStateRequest applicationStateRequest);
    void delete(int id);
}
