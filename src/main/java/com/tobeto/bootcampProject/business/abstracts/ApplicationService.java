package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.CreateApplicationRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateApplicationRequest;
import com.tobeto.bootcampProject.business.responses.get.GetAllApplicationsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdApplicationResponse;

import java.util.List;

public interface ApplicationService {
    List<GetAllApplicationsResponse> getAll();
    GetByIdApplicationResponse getByID(int id);

    void add(CreateApplicationRequest applicationRequest);
    void update(UpdateApplicationRequest applicationRequest);
    void delete(int id);
}
