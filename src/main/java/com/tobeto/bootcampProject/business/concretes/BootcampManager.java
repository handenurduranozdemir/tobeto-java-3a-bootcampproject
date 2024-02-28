package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.BootcampService;
import com.tobeto.bootcampProject.business.requests.create.CreateBootcampRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateBootcampRequest;
import com.tobeto.bootcampProject.business.responses.get.GetAllBootcampsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdBootcampResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.BootcampRepository;
import com.tobeto.bootcampProject.entities.Bootcamp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
    private BootcampRepository bootcampRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllBootcampsResponse> getAll() {
        List<Bootcamp> bootcamps = bootcampRepository.findAll();

        List<GetAllBootcampsResponse> getAllBootcampsResponses = bootcamps.stream()
                .map(bootcamp -> modelMapperService.forResponse()
                        .map(bootcamp, GetAllBootcampsResponse.class)).collect(Collectors.toList());

        return getAllBootcampsResponses;
    }

    @Override
    public GetByIdBootcampResponse getById(int id) {
        Bootcamp bootcamp = bootcampRepository.findById(id).orElseThrow();
        GetByIdBootcampResponse bootcampResponse = modelMapperService.forResponse()
                .map(bootcamp, GetByIdBootcampResponse.class);
        return bootcampResponse;
    }

    @Override
    public void add(CreateBootcampRequest bootcampRequest) {
        Bootcamp bootcamp = modelMapperService.forRequest().map(bootcampRequest, Bootcamp.class);
        this.bootcampRepository.save(bootcamp);
    }

    @Override
    public void update(UpdateBootcampRequest bootcampRequest) {
        Bootcamp bootcamp = modelMapperService.forRequest().map(bootcampRequest, Bootcamp.class);
        bootcampRepository.save(bootcamp);
    }

    @Override
    public void delete(int id) {
        bootcampRepository.deleteById(id);
    }
}
