package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.CreateBootcampStateRequest;
import com.tobeto.bootcampProject.business.requests.UpdateBootcampStateRequest;
import com.tobeto.bootcampProject.business.responses.GetAllBootcampStatesResponse;
import com.tobeto.bootcampProject.business.responses.GetByIdBootcampStateResponse;

import java.util.List;

public interface BootcampStateService {
    List<GetAllBootcampStatesResponse> getAll();
    GetByIdBootcampStateResponse getById(int id);
    void add(CreateBootcampStateRequest bootcampStateRequest);
    void update(UpdateBootcampStateRequest bootcampStateRequest);
    void delete(int id);
}
