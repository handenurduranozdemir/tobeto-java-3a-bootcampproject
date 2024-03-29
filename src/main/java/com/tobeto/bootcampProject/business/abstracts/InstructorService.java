package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.create.CreateInstructorResponse;
import com.tobeto.bootcampProject.business.responses.get.GetAllInstructorsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdInstructorResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateInstructorResponse;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;

import java.util.List;

public interface InstructorService {
    DataResult<List<GetAllInstructorsResponse>> getAll();
    DataResult<GetByIdInstructorResponse> getById(int id);
    DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest);
    DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest);
    Result delete(int id);
    void checkIfUserExist(String nationalIdentity);
}

