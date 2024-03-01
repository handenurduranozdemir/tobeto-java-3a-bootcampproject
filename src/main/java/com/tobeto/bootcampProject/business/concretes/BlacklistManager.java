package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.BlacklistService;
import com.tobeto.bootcampProject.business.requests.create.CreateBlacklistRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateBlacklistRequest;
import com.tobeto.bootcampProject.business.responses.create.CreateBlacklistResponse;
import com.tobeto.bootcampProject.business.responses.get.GetAllBlacklistResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdBlacklistResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateBlacklistResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;
import com.tobeto.bootcampProject.core.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.results.SuccessResult;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.BlacklistRepository;
import com.tobeto.bootcampProject.entities.Blacklist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlacklistManager implements BlacklistService {
    private ModelMapperService modelMapperService;
    private BlacklistRepository blacklistRepository;

    @Override
    public DataResult<List<GetAllBlacklistResponse>> getAll() {
        List<Blacklist> blacklists = blacklistRepository.findAll();

        List<GetAllBlacklistResponse> responses = blacklists.stream()
                .map(blacklist -> modelMapperService.forResponse()
                        .map(blacklist, GetAllBlacklistResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBlacklistResponse>>(responses, "All blacklists are listed");
    }

    @Override
    public DataResult<GetByIdBlacklistResponse> getById(int id) {
        Blacklist blacklist = blacklistRepository.findById(id).orElseThrow();
        GetByIdBlacklistResponse response = modelMapperService.forResponse()
                .map(blacklist, GetByIdBlacklistResponse.class);
        return new SuccessDataResult<GetByIdBlacklistResponse>(response, "Blacklist(Applicant) is found");
    }

    @Override
    public DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest blacklistRequest) {
        Blacklist blacklist = modelMapperService.forRequest().map(blacklistRequest, Blacklist.class);
        blacklistRepository.save(blacklist);

        blacklist.setDate(LocalDateTime.now());

        CreateBlacklistResponse response = modelMapperService.forResponse().map(blacklist, CreateBlacklistResponse.class);
        return new SuccessDataResult<CreateBlacklistResponse>(response, "Applicant is added to blacklist");
    }

    @Override
    public DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest blacklistRequest, int id) {
        Blacklist blacklist = blacklistRepository.findById(id).orElseThrow();
        Blacklist updatedBlacklist = modelMapperService.forRequest().map(blacklistRequest,Blacklist.class);

        blacklist.setId(id);
        blacklist.setDate(LocalDateTime.now());
        blacklist.setReason(updatedBlacklist.getReason());
        blacklist.setApplicant(updatedBlacklist.getApplicant());
        blacklist.setDate(updatedBlacklist.getDate());
        blacklistRepository.save(blacklist);

        UpdateBlacklistResponse response = modelMapperService.forResponse().map(blacklist, UpdateBlacklistResponse.class);

        return new SuccessDataResult<UpdateBlacklistResponse>(response, "Blacklist(Applicant) is updated");
    }

    @Override
    public Result delete(int id) {
        blacklistRepository.deleteById(id);
        return new SuccessResult("Blacklist(Applicant) is deleted");
    }
}
