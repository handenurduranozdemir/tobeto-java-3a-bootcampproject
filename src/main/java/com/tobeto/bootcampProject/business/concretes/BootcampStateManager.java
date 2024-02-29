package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.BootcampStateService;
import com.tobeto.bootcampProject.business.requests.create.CreateBootcampStateRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateBootcampStateRequest;
import com.tobeto.bootcampProject.business.responses.create.CreateApplicationStateResponse;
import com.tobeto.bootcampProject.business.responses.create.CreateBootcampStateResponse;
import com.tobeto.bootcampProject.business.responses.get.GetAllBootcampStatesResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdBootcampStateResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateBootcampStateResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;
import com.tobeto.bootcampProject.core.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.results.SuccessResult;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.BootcampStateRepository;
import com.tobeto.bootcampProject.entities.BootcampState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampStateManager implements BootcampStateService {
    private BootcampStateRepository bootcampStateRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllBootcampStatesResponse>> getAll() {
        List<BootcampState> bootcampStates = bootcampStateRepository.findAll();

        List<GetAllBootcampStatesResponse> responses = bootcampStates.stream()
                .map(bootcampState -> modelMapperService.forResponse()
                        .map(bootcampState, GetAllBootcampStatesResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBootcampStatesResponse>>(responses, "All bootcamp states are listed");
    }

    @Override
    public DataResult<GetByIdBootcampStateResponse> getById(int id) {
        BootcampState bootcampState = bootcampStateRepository.findById(id).orElseThrow();
        GetByIdBootcampStateResponse response = modelMapperService.forResponse()
                .map(bootcampState, GetByIdBootcampStateResponse.class);
        return new SuccessDataResult<GetByIdBootcampStateResponse>(response, "Bootcamp state is found");
    }

    @Override
    public DataResult<CreateBootcampStateResponse> add(CreateBootcampStateRequest bootcampStateRequest) {
        BootcampState bootcampState = modelMapperService.forRequest()
                .map(bootcampStateRequest, BootcampState.class);

        bootcampStateRepository.save(bootcampState);

        CreateBootcampStateResponse response = modelMapperService.forResponse()
                .map(bootcampState, CreateBootcampStateResponse.class);

        return new SuccessDataResult<CreateBootcampStateResponse>(response, "Bootcamp is created");
    }

    @Override
    public DataResult<UpdateBootcampStateResponse> update(UpdateBootcampStateRequest bootcampStateRequest, int id) {
        BootcampState bootcampState = bootcampStateRepository.findById(id).orElseThrow();
        BootcampState updatedBootcampState = modelMapperService.forRequest().map(bootcampStateRequest,BootcampState.class);

        bootcampState.setUpdatedDate(LocalDateTime.now());
        bootcampState.setId(id);
        bootcampStateRepository.save(bootcampState);

        UpdateBootcampStateResponse response = modelMapperService.forResponse().map(bootcampState, UpdateBootcampStateResponse.class);

        return new SuccessDataResult<UpdateBootcampStateResponse>(response, "Bootcamp state is updated");
    }

    @Override
    public Result delete(int id) {
        bootcampStateRepository.deleteById(id);

        return new SuccessResult("Bootcamp is deleted");
    }
}
