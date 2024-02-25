package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.requests.UpdateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.GetAllInstructorsResponse;
import com.tobeto.bootcampProject.business.responses.GetByIdInstructorResponse;


import java.util.List;

public interface InstructorService {
    List<GetAllInstructorsResponse> getAll();
    GetByIdInstructorResponse getById(int id);
    void add(CreateInstructorRequest createInstructorRequest);
    void update(UpdateInstructorRequest updateInstructorRequest);
    void delete(int id);
}
