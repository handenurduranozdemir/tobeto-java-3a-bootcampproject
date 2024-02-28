package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.CreateBootcampStateRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateBootcampStateRequest;
import com.tobeto.bootcampProject.business.responses.get.GetAllBootcampStatesResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdBootcampStateResponse;

import java.util.List;

public interface BootcampStateService {
    List<GetAllBootcampStatesResponse> getAll();
    GetByIdBootcampStateResponse getById(int id);
    void add(CreateBootcampStateRequest bootcampStateRequest);
    void update(UpdateBootcampStateRequest bootcampStateRequest);
    void delete(int id);
}
