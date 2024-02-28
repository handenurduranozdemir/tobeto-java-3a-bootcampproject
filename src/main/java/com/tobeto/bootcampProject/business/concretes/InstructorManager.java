package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.InstructorService;
import com.tobeto.bootcampProject.business.requests.create.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.get.GetAllInstructorsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdInstructorResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.InstructorRepository;
import com.tobeto.bootcampProject.entities.Instructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
    private InstructorRepository instructorRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllInstructorsResponse> getAll() {
        List<Instructor> instructors=instructorRepository.findAll();
        List<GetAllInstructorsResponse> getAllInstructorResponses=instructors.stream()
                .map(instructor->modelMapperService.forResponse()
                        .map(instructor, GetAllInstructorsResponse.class)).collect(Collectors.toList());

        return getAllInstructorResponses;
    }

    @Override
    public GetByIdInstructorResponse getById(int id) {
        Instructor instructor=instructorRepository.findById(id).orElseThrow();
        GetByIdInstructorResponse response=modelMapperService.forResponse()
                .map(instructor,GetByIdInstructorResponse.class);
        return response;
    }

    @Override
    public void add(CreateInstructorRequest createInstructorRequest) {
        Instructor instructor=modelMapperService.forRequest().map(createInstructorRequest,Instructor.class);//mapped
        this.instructorRepository.save(instructor);
    }

    @Override
    public void update(UpdateInstructorRequest updateInstructorRequest) {
        Instructor instructor=modelMapperService.forRequest().map(updateInstructorRequest,Instructor.class);//mapped
        this.instructorRepository.save(instructor);
    }

    @Override
    public void delete(int id) {
        instructorRepository.deleteById(id);
    }
}
