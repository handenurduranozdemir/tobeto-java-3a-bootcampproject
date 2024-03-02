package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.ApplicationStateService;
import com.tobeto.bootcampProject.business.requests.create.CreateApplicationStateRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateApplicationStateRequest;
import com.tobeto.bootcampProject.business.responses.create.CreateApplicationStateResponse;
import com.tobeto.bootcampProject.business.responses.get.GetAllApplicationStatesResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdApplicationStateResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateApplicationStateResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;
import com.tobeto.bootcampProject.core.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.results.SuccessResult;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.ApplicationStateRepository;
import com.tobeto.bootcampProject.entities.ApplicationState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationStateManager implements ApplicationStateService {
    private ApplicationStateRepository applicationStateRepository;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<List<GetAllApplicationStatesResponse>> getAll() {
        List<ApplicationState> applicationStates = applicationStateRepository.findAll();
        List<GetAllApplicationStatesResponse> responses = applicationStates.stream()
                .map(applicationState -> modelMapperService.forRequest()
                        .map(applicationState, GetAllApplicationStatesResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllApplicationStatesResponse>>(responses, "All application states are listed");
    }

    @Override
    public DataResult<GetByIdApplicationStateResponse> getById(int id) {
        ApplicationState applicationState = applicationStateRepository.findById(id).orElseThrow();
        GetByIdApplicationStateResponse response = modelMapperService.forResponse()
                .map(applicationState, GetByIdApplicationStateResponse.class);
        return new SuccessDataResult<GetByIdApplicationStateResponse>(response, "Application state is found");
    }

    @Override
    public DataResult<CreateApplicationStateResponse> add(CreateApplicationStateRequest applicationStateRequest) {
        ApplicationState applicationState = modelMapperService.forRequest()
                .map(applicationStateRequest, ApplicationState.class);

        applicationStateRepository.save(applicationState);

        CreateApplicationStateResponse response = modelMapperService.forResponse()
                .map(applicationState, CreateApplicationStateResponse.class);

        return new SuccessDataResult<CreateApplicationStateResponse>(response, "Application state is created");
    }

    @Override
    public DataResult<UpdateApplicationStateResponse> update(UpdateApplicationStateRequest applicationStateRequest) {
        ApplicationState applicationState = applicationStateRepository.findById(applicationStateRequest.getId()).orElseThrow();
        ApplicationState updatedApplicationState = modelMapperService.forRequest().map(applicationStateRequest, ApplicationState.class);

        applicationState.setUpdatedDate(LocalDateTime.now());
        applicationStateRepository.save(applicationState);

        UpdateApplicationStateResponse response = modelMapperService.forResponse().map(applicationState, UpdateApplicationStateResponse.class);

        return new SuccessDataResult<UpdateApplicationStateResponse>(response, "Application state updated");
    }

    @Override
    public Result delete(int id) {
        applicationStateRepository.deleteById(id);
        return new SuccessResult("Application state is deleted");
    }
}
