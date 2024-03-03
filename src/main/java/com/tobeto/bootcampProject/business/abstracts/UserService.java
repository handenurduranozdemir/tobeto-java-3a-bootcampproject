package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.responses.get.GetAllUserResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByEmailUserResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdUserResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;

import java.util.List;

public interface UserService {
    DataResult<List<GetAllUserResponse>> getAll();
    DataResult<GetByEmailUserResponse> getByEmail(String email);
    DataResult<GetByIdUserResponse> getById(int id);
    Result delete(int id);
    void checkIfUserExist(String nationalIdentity);
}
