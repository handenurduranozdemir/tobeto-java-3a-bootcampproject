package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.CreateBootcampRequest;
import com.tobeto.bootcampProject.business.requests.UpdateBootcampRequest;
import com.tobeto.bootcampProject.business.responses.GetAllBootcampsResponse;
import com.tobeto.bootcampProject.business.responses.GetByIdBootcampResponse;

import java.util.List;

public interface BootcampService {
    List<GetAllBootcampsResponse> getAll();
    GetByIdBootcampResponse getById(int id);
    void add(CreateBootcampRequest bootcampRequest);
    void update(UpdateBootcampRequest bootcampRequest);
    void delete(int id);
}
