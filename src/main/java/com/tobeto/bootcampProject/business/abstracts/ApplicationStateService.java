package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.CreateApplicationStateRequest;
import com.tobeto.bootcampProject.business.requests.UpdateApplicationStateRequest;
import com.tobeto.bootcampProject.business.responses.GetAllApplicationStatesResponse;
import com.tobeto.bootcampProject.business.responses.GetByIdApplicationStateResponse;

import java.util.List;

public interface ApplicationStateService {
    List<GetAllApplicationStatesResponse> getAll();
    GetByIdApplicationStateResponse getById(int id);
    void add(CreateApplicationStateRequest applicationStateRequest);
    void update(UpdateApplicationStateRequest applicationStateRequest);
    void delete(int id);
}
