package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.ApplicationStateService;
import com.tobeto.bootcampProject.business.requests.create.CreateApplicationStateRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateApplicationStateRequest;
import com.tobeto.bootcampProject.business.responses.get.GetAllApplicationStatesResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdApplicationStateResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.ApplicationStateRepository;
import com.tobeto.bootcampProject.entities.ApplicationState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationStateManager implements ApplicationStateService {
    private ApplicationStateRepository applicationStateRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllApplicationStatesResponse> getAll() {
        List<ApplicationState> applicationStates = applicationStateRepository.findAll();

        List<GetAllApplicationStatesResponse> applicationStatesResponses = applicationStates.stream()
                .map(applicationState -> modelMapperService.forRequest()
                        .map(applicationState, GetAllApplicationStatesResponse.class)).collect(Collectors.toList());
        return applicationStatesResponses;
    }

    @Override
    public GetByIdApplicationStateResponse getById(int id) {
        ApplicationState applicationState = applicationStateRepository.findById(id).orElseThrow();
        GetByIdApplicationStateResponse applicationStateResponse = modelMapperService.forResponse()
                .map(applicationState, GetByIdApplicationStateResponse.class);
        return applicationStateResponse;
    }

    @Override
    public void add(CreateApplicationStateRequest applicationStateRequest) {
        ApplicationState applicationState = modelMapperService.forRequest().map(applicationStateRequest, ApplicationState.class);
        this.applicationStateRepository.save(applicationState);
    }

    @Override
    public void update(UpdateApplicationStateRequest applicationStateRequest) {
        ApplicationState applicationState = modelMapperService.forRequest().map(applicationStateRequest, ApplicationState.class);
        this.applicationStateRepository.save(applicationState);
    }

    @Override
    public void delete(int id) {
        applicationStateRepository.deleteById(id);
    }
}
