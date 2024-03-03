package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.BootcampService;
import com.tobeto.bootcampProject.business.requests.create.CreateBootcampRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateBootcampRequest;
import com.tobeto.bootcampProject.business.responses.create.CreateBootcampResponse;
import com.tobeto.bootcampProject.business.responses.get.GetAllBootcampsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdBootcampResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateBootcampResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;
import com.tobeto.bootcampProject.core.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.results.SuccessResult;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.ApplicationRepository;
import com.tobeto.bootcampProject.dataacces.BootcampRepository;
import com.tobeto.bootcampProject.dataacces.BootcampStateRepository;
import com.tobeto.bootcampProject.dataacces.InstructorRepository;
import com.tobeto.bootcampProject.entities.Bootcamp;
import com.tobeto.bootcampProject.entities.BootcampState;
import com.tobeto.bootcampProject.entities.Instructor;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
    private BootcampRepository bootcampRepository;
    private BootcampStateRepository bootcampStateRepository;
    private InstructorRepository instructorRepository;
    private ModelMapperService modelMapperService;
    private final ApplicationRepository applicationRepository;

    @Override
    public DataResult<List<GetAllBootcampsResponse>> getAll() {
        List<Bootcamp> bootcamps = bootcampRepository.findAll();
        List<GetAllBootcampsResponse> responses = bootcamps.stream()
                .map(bootcamp -> modelMapperService.forResponse()
                        .map(bootcamp, GetAllBootcampsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllBootcampsResponse>>(responses, "All bootcamps are listed");
    }

    @Override
    public DataResult<GetByIdBootcampResponse> getById(int id) {
        Bootcamp bootcamp = bootcampRepository.findById(id).orElseThrow();
        GetByIdBootcampResponse response = modelMapperService.forResponse()
                .map(bootcamp, GetByIdBootcampResponse.class);
        return new SuccessDataResult<GetByIdBootcampResponse>(response, "Bootcamp is found");
    }

    @Override
    public DataResult<CreateBootcampResponse> add(CreateBootcampRequest bootcampRequest) {
        Bootcamp bootcamp = modelMapperService.forRequest().map(bootcampRequest, Bootcamp.class);

        BootcampState bootcampState = bootcampStateRepository.findById(bootcampRequest.getBootcampStateId())
                .orElseThrow(() -> new EntityNotFoundException("BootcampState not found"));
        bootcamp.setBootcampState(bootcampState);

        Instructor instructor = instructorRepository.findById(bootcampRequest.getInstructorId())
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found"));
        bootcamp.setInstructor(instructor);

        bootcampRepository.save(bootcamp);

        CreateBootcampResponse response = modelMapperService.forResponse().map(bootcamp, CreateBootcampResponse.class);
        return new SuccessDataResult<CreateBootcampResponse>(response, "Bootcamp is created");
    }

    @Override
    public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest bootcampRequest) {
        Bootcamp bootcamp = bootcampRepository.findById(bootcampRequest.getId()).orElseThrow();
        Bootcamp updatedBootcamp = modelMapperService.forRequest().map(bootcampRequest, Bootcamp.class);

        bootcamp.setUpdatedDate(LocalDateTime.now());
        bootcamp.setInstructor(updatedBootcamp.getInstructor() !=
                null ? updatedBootcamp.getInstructor() : bootcamp.getInstructor());
        bootcamp.setBootcampState(updatedBootcamp.getBootcampState() !=
                null ? updatedBootcamp.getBootcampState() : bootcamp.getBootcampState());
        bootcamp.setName(updatedBootcamp.getName() !=
                null ? updatedBootcamp.getName() : bootcamp.getName());
        bootcamp.setEndDate(updatedBootcamp.getEndDate() !=
                null ? updatedBootcamp.getEndDate() : bootcamp.getEndDate());
        bootcamp.setStartDate(updatedBootcamp.getStartDate() !=
                null ? updatedBootcamp.getStartDate() : bootcamp.getStartDate());

        bootcampRepository.save(bootcamp);
        UpdateBootcampResponse response = modelMapperService.forResponse().map(bootcamp, UpdateBootcampResponse.class);

        return new SuccessDataResult<UpdateBootcampResponse>(response, "Bootcamp is updated");
    }

    @Override
    public Result delete(int id) {
        bootcampRepository.deleteById(id);

        return new SuccessResult("Bootcamp is deleted");
    }
}
