package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.ApplicationService;
import com.tobeto.bootcampProject.business.requests.create.CreateApplicationRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateApplicationRequest;
import com.tobeto.bootcampProject.business.responses.create.CreateApplicationResponse;
import com.tobeto.bootcampProject.business.responses.get.GetAllApplicationsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdApplicationResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateApplicationResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;
import com.tobeto.bootcampProject.core.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.results.SuccessResult;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.ApplicationRepository;
import com.tobeto.bootcampProject.entities.Application;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
    private ApplicationRepository applicationRepository;
    private ModelMapperService modelMapperService;
    @Override

    public DataResult<List<GetAllApplicationsResponse>> getAll() {
        List<Application> applications = applicationRepository.findAll();
        List<GetAllApplicationsResponse> responses = applications.stream()
                .map(application -> modelMapperService.forResponse()
                        .map(application, GetAllApplicationsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllApplicationsResponse>>(responses,"All applications are listed");
    }

    @Override
    public DataResult<GetByIdApplicationResponse> getByID(int id) {
        Application application = applicationRepository.findById(id).orElseThrow();
        GetByIdApplicationResponse response = modelMapperService.forResponse()
                .map(application, GetByIdApplicationResponse.class);
        return new SuccessDataResult<GetByIdApplicationResponse>(response,"Applicantion is found");
    }

    @Override
    public DataResult<CreateApplicationResponse> add(CreateApplicationRequest applicationRequest) {
        Application application = modelMapperService.forRequest().map(applicationRequest,Application.class);
        applicationRepository.save(application);

        application.setCreatedDate(LocalDateTime.now());

        CreateApplicationResponse response = modelMapperService.forResponse().map(application, CreateApplicationResponse.class);

        return new SuccessDataResult<CreateApplicationResponse>(response, "Application is created");
    }

    @Override
    public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest applicationRequest, int id) {
        Application application = applicationRepository.findById(id).orElseThrow();
        Application updatedApplication = modelMapperService.forRequest().map(applicationRequest, Application.class);

        application.setId(id);
        application.setUpdatedDate(LocalDateTime.now());
        application.setApplicant(updatedApplication.getApplicant());
        application.setBootcamp(updatedApplication.getBootcamp());
        application.setApplicationState(updatedApplication.getApplicationState());
        applicationRepository.save(application);

        UpdateApplicationResponse response = modelMapperService.forResponse().map(application, UpdateApplicationResponse.class);

        return new SuccessDataResult<UpdateApplicationResponse>(response, "Application is updated");
    }

    @Override
    public Result delete(int id) {
        applicationRepository.deleteById(id);
        return new SuccessResult("Application deleted");
    }
}
