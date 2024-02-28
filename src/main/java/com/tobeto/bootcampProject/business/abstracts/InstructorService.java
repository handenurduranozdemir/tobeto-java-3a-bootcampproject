package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.get.GetAllInstructorsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdInstructorResponse;


import java.util.List;

public interface InstructorService {
    List<GetAllInstructorsResponse> getAll();
    GetByIdInstructorResponse getById(int id);
    void add(CreateInstructorRequest createInstructorRequest);
    void update(UpdateInstructorRequest updateInstructorRequest);
    void delete(int id);
}
