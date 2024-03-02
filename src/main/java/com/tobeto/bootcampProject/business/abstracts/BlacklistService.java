package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.CreateBlacklistRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateBlacklistRequest;
import com.tobeto.bootcampProject.business.responses.create.CreateBlacklistResponse;
import com.tobeto.bootcampProject.business.responses.get.GetAllBlacklistResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdBlacklistResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateBlacklistResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;

import java.util.List;

public interface BlacklistService {
    DataResult<List<GetAllBlacklistResponse>> getAll();
    DataResult<GetByIdBlacklistResponse> getById(int id);
    DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest blacklistRequest);
    DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest blacklistRequest);
    Result delete(int id);
}
