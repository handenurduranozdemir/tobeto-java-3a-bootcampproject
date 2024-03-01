package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.get.GetAllInstructorsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdInstructorResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateInstructorResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;

import java.util.List;

public interface InstructorService {
    DataResult<List<GetAllInstructorsResponse>> getAll();
    DataResult<GetByIdInstructorResponse> getById(int id);
    void add(CreateInstructorRequest createInstructorRequest);
    DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest, int id);
    Result delete(int id);
}
