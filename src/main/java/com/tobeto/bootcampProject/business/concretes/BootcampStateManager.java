package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.BootcampStateService;
import com.tobeto.bootcampProject.business.requests.CreateBootcampStateRequest;
import com.tobeto.bootcampProject.business.requests.UpdateBootcampStateRequest;
import com.tobeto.bootcampProject.business.responses.GetAllBootcampStatesResponse;
import com.tobeto.bootcampProject.business.responses.GetByIdBootcampStateResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.BootcampStateRepository;
import com.tobeto.bootcampProject.entities.BootcampState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampStateManager implements BootcampStateService {
    private BootcampStateRepository bootcampStateRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBootcampStatesResponse> getAll() {
        List<BootcampState> bootcampStates = bootcampStateRepository.findAll();

        List<GetAllBootcampStatesResponse> allBootcampStatesResponses = bootcampStates.stream()
                .map(bootcampState -> modelMapperService.forResponse()
                        .map(bootcampState, GetAllBootcampStatesResponse.class)).collect(Collectors.toList());
        return allBootcampStatesResponses;
    }

    @Override
    public GetByIdBootcampStateResponse getById(int id) {
        BootcampState bootcampState = bootcampStateRepository.findById(id).orElseThrow();
        GetByIdBootcampStateResponse bootcampStateResponse = modelMapperService.forResponse()
                .map(bootcampState, GetByIdBootcampStateResponse.class);
        return bootcampStateResponse;
    }

    @Override
    public void add(CreateBootcampStateRequest bootcampStateRequest) {
        BootcampState bootcampState = modelMapperService.forRequest().map(bootcampStateRequest, BootcampState.class);
        this.bootcampStateRepository.save(bootcampState);
    }

    @Override
    public void update(UpdateBootcampStateRequest bootcampStateRequest) {
        BootcampState bootcampState = modelMapperService.forRequest().map(bootcampStateRequest,BootcampState.class);
        this.bootcampStateRepository.save(bootcampState);
    }

    @Override
    public void delete(int id) {
        bootcampStateRepository.deleteById(id);
    }
}
