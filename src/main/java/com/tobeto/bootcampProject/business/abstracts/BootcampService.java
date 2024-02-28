package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.CreateBootcampRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateBootcampRequest;
import com.tobeto.bootcampProject.business.responses.get.GetAllBootcampsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdBootcampResponse;

import java.util.List;

public interface BootcampService {
    List<GetAllBootcampsResponse> getAll();
    GetByIdBootcampResponse getById(int id);
    void add(CreateBootcampRequest bootcampRequest);
    void update(UpdateBootcampRequest bootcampRequest);
    void delete(int id);
}
