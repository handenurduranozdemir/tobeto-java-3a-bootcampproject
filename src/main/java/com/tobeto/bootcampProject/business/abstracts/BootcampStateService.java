package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.CreateBootcampStateRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateBootcampStateRequest;
import com.tobeto.bootcampProject.business.responses.create.CreateBootcampStateResponse;
import com.tobeto.bootcampProject.business.responses.get.GetAllBootcampStatesResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdBootcampStateResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateBootcampStateResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;

import java.util.List;

public interface BootcampStateService {
    DataResult<List<GetAllBootcampStatesResponse>> getAll();
    DataResult<GetByIdBootcampStateResponse> getById(int id);
    DataResult<CreateBootcampStateResponse> add(CreateBootcampStateRequest bootcampStateRequest);
    DataResult<UpdateBootcampStateResponse> update(UpdateBootcampStateRequest bootcampStateRequest, int id);
    Result delete(int id);
}
