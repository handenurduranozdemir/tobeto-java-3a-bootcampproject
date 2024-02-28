package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.ApplicationService;
import com.tobeto.bootcampProject.business.requests.create.CreateApplicationRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateApplicationRequest;
import com.tobeto.bootcampProject.business.responses.get.GetAllApplicationsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdApplicationResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.ApplicationRepository;
import com.tobeto.bootcampProject.entities.Application;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
    private ApplicationRepository applicationRepository;
    private ModelMapperService modelMapperService;
    @Override

    public List<GetAllApplicationsResponse> getAll() {
        List<Application> applications = applicationRepository.findAll();

        List<GetAllApplicationsResponse> allApplicationsResponses = applications.stream()
                .map(application -> modelMapperService.forResponse()
                        .map(application, GetAllApplicationsResponse.class)).collect(Collectors.toList());

        return allApplicationsResponses;
    }

    @Override
    public GetByIdApplicationResponse getByID(int id) {
        Application application = applicationRepository.findById(id).orElseThrow();
        GetByIdApplicationResponse applicationResponse = modelMapperService.forResponse()
                .map(application, GetByIdApplicationResponse.class);
        return applicationResponse;
    }

    @Override
    public void add(CreateApplicationRequest applicationRequest) {
        Application application = modelMapperService.forRequest().map(applicationRequest,Application.class);
        this.applicationRepository.save(application);
    }

    @Override
    public void update(UpdateApplicationRequest applicationRequest) {
        Application application = modelMapperService.forRequest().map(applicationRequest, Application.class);
        applicationRepository.save(application);
    }

    @Override
    public void delete(int id) {
        applicationRepository.deleteById(id);
    }
}
