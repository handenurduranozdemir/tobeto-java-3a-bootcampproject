package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.InstructorService;
import com.tobeto.bootcampProject.business.requests.create.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.get.GetAllInstructorsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdInstructorResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateInstructorResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;
import com.tobeto.bootcampProject.core.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.results.SuccessResult;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.InstructorRepository;
import com.tobeto.bootcampProject.entities.Instructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
    private InstructorRepository instructorRepository;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<List<GetAllInstructorsResponse>> getAll() {
        List<Instructor> instructors = instructorRepository.findAll();
        List<GetAllInstructorsResponse> responses = instructors.stream()
                .map(instructor->modelMapperService.forResponse()
                        .map(instructor, GetAllInstructorsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllInstructorsResponse>>(responses, "All isntructors are listed");
    }

    @Override
    public DataResult<GetByIdInstructorResponse> getById(int id) {
        Instructor instructor=instructorRepository.findById(id).orElseThrow();
        GetByIdInstructorResponse response=modelMapperService.forResponse()
                .map(instructor,GetByIdInstructorResponse.class);
        return new SuccessDataResult<GetByIdInstructorResponse>(response, "Instructor is found");
    }

    @Override
    public void add(CreateInstructorRequest createInstructorRequest) {
        Instructor instructor=modelMapperService.forRequest().map(createInstructorRequest,Instructor.class);//mapped
        instructorRepository.save(instructor);
    }

    @Override
    public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest, int id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow();
        Instructor updatedInstructor=modelMapperService.forRequest().map(updateInstructorRequest,Instructor.class);//mapped

        instructor.setId(id);
        instructor.setUpdatedDate(LocalDateTime.now());
        instructor.setFirstName(updatedInstructor.getFirstName());
        instructor.setLastName(updatedInstructor.getLastName());
        instructor.setUsername(updatedInstructor.getUsername());
        instructor.setNationalIdentity(updatedInstructor.getNationalIdentity());
        instructor.setDateOfBirth(updatedInstructor.getDateOfBirth());
        instructor.setCompanyName(updatedInstructor.getCompanyName());

        instructorRepository.save(instructor);
        UpdateInstructorResponse response = modelMapperService.forResponse().map(instructor, UpdateInstructorResponse.class);

        return new SuccessDataResult<UpdateInstructorResponse>(response, "Instructor updated");
    }

    @Override
    public Result delete(int id) {
        instructorRepository.deleteById(id);
        return new SuccessResult("Instructor is deleted");
    }
}
