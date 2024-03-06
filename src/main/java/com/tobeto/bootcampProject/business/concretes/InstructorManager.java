package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.InstructorService;
import com.tobeto.bootcampProject.business.requests.create.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.create.CreateInstructorResponse;
import com.tobeto.bootcampProject.business.responses.get.GetAllInstructorsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdInstructorResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateInstructorResponse;
import com.tobeto.bootcampProject.core.exceptions.types.BusinessException;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.InstructorRepository;
import com.tobeto.bootcampProject.dataacces.UserRepository;
import com.tobeto.bootcampProject.entities.Instructor;
import com.tobeto.bootcampProject.entities.User;
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
    private final UserRepository userRepository;

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
    public DataResult<CreateInstructorResponse> add(CreateInstructorRequest instructorRequest) {
        checkIfUserExist(instructorRequest.getNationalIdentity());
        Instructor instructor=modelMapperService.forRequest().map(instructorRequest,Instructor.class);
        instructorRepository.save(instructor);

        CreateInstructorResponse response = modelMapperService.forResponse()
                .map(instructor, CreateInstructorResponse.class);

        return new SuccessDataResult<CreateInstructorResponse>(response, "Instructor is created");
    }

    @Override
    public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest instructorRequest) {
        Instructor instructor = instructorRepository.findById(instructorRequest.getId()).orElseThrow();
        Instructor updatedInstructor=modelMapperService.forRequest().map(instructorRequest,Instructor.class);

        instructor.setUpdatedDate(LocalDateTime.now());
        instructor.setFirstName(updatedInstructor.getFirstName() !=
                null ? updatedInstructor.getFirstName() : instructor.getFirstName());
        instructor.setLastName(updatedInstructor.getLastName() !=
                null ? updatedInstructor.getLastName() : instructor.getLastName());
        instructor.setUsername(updatedInstructor.getUsername() !=
                null ? updatedInstructor.getUsername() : instructor.getUsername());
        instructor.setNationalIdentity(updatedInstructor.getNationalIdentity() !=
                null ? updatedInstructor.getNationalIdentity() : instructor.getNationalIdentity());
        instructor.setDateOfBirth(updatedInstructor.getDateOfBirth() !=
                null ? updatedInstructor.getDateOfBirth() : instructor.getDateOfBirth());
        instructor.setCompanyName(updatedInstructor.getCompanyName() !=
                null ? updatedInstructor.getCompanyName() : instructor.getCompanyName());

        instructorRepository.save(instructor);
        UpdateInstructorResponse response = modelMapperService.forResponse().map(instructor, UpdateInstructorResponse.class);

        return new SuccessDataResult<UpdateInstructorResponse>(response, "Instructor updated");
    }

    @Override
    public Result delete(int id) {
        instructorRepository.deleteById(id);
        return new SuccessResult("Instructor is deleted");
    }

    @Override
    public void checkIfUserExist(String nationalIdentity) {
        User instructor = userRepository.findByNationalIdentity(nationalIdentity);
        if(instructor != null)
            throw new BusinessException("Instructor is already created");
    }
}