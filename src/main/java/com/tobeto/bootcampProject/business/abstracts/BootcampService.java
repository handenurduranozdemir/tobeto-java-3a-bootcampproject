package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.CreateBootcampRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateBootcampRequest;
import com.tobeto.bootcampProject.business.responses.create.CreateBootcampResponse;
import com.tobeto.bootcampProject.business.responses.get.GetAllBootcampsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdBootcampResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateBootcampResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;

import java.util.List;

public interface BootcampService {
    DataResult<List<GetAllBootcampsResponse>> getAll();
    DataResult<GetByIdBootcampResponse> getById(int id);
    DataResult<CreateBootcampResponse> add(CreateBootcampRequest bootcampRequest);
    DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest bootcampRequest, int id);
    Result delete(int id);
}
