package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.CreateApplicationRequest;
import com.tobeto.bootcampProject.business.requests.UpdateApplicationRequest;
import com.tobeto.bootcampProject.business.responses.GetAllApplicationsResponse;
import com.tobeto.bootcampProject.business.responses.GetByIdApplicationResponse;

import java.util.List;

public interface ApplicationService {
    List<GetAllApplicationsResponse> getAll();
    GetByIdApplicationResponse getByID(int id);

    void add(CreateApplicationRequest applicationRequest);
    void update(UpdateApplicationRequest applicationRequest);
    void delete(int id);
}
