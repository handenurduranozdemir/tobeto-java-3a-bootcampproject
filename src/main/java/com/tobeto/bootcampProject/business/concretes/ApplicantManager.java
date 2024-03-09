package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.ApplicantService;
import com.tobeto.bootcampProject.business.requests.create.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.update.UpdateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.create.CreateApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.GetAllApplicantsResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdApplicantResponse;
import com.tobeto.bootcampProject.business.responses.update.UpdateApplicantResponse;
import com.tobeto.bootcampProject.core.aspects.logging.Loggable;
import com.tobeto.bootcampProject.core.exceptions.types.BusinessException;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.ApplicantRepository;
import com.tobeto.bootcampProject.dataacces.UserRepository;
import com.tobeto.bootcampProject.entities.Applicant;
import com.tobeto.bootcampProject.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

    private ApplicantRepository applicantRepository;
    private ModelMapperService modelMapperService;
    private final UserRepository userRepository;

    @Override
    public DataResult<List<GetAllApplicantsResponse>> getAll() {
        List<Applicant> applicants = applicantRepository.findAll();

        List<GetAllApplicantsResponse> responses = applicants.stream()
                .map(applicant->modelMapperService.forResponse()
                        .map(applicant, GetAllApplicantsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllApplicantsResponse>>(responses, "All applicants are listed");
    }

    @Override
    public DataResult<GetByIdApplicantResponse> getById(int id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow();
        GetByIdApplicantResponse response = modelMapperService.forResponse()
                .map(applicant, GetByIdApplicantResponse.class);
        return new SuccessDataResult<GetByIdApplicantResponse>(response, "Applicant is listed");
    }

    @Override
    @Loggable
    public DataResult<CreateApplicantResponse> add(CreateApplicantRequest applicantRequest) {
        checkIfUserExist(applicantRequest.getNationalIdentity());
        Applicant applicant = modelMapperService.forRequest()
                .map(applicantRequest,Applicant.class);
        applicantRepository.save(applicant);

        CreateApplicantResponse response = modelMapperService.forResponse().map(applicant, CreateApplicantResponse.class);
        return new SuccessDataResult<CreateApplicantResponse>(response, "Applicant is created");
    }

    public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest applicantRequest) {
        Applicant applicant = applicantRepository.findById(applicantRequest.getId()).orElseThrow();
        Applicant updatedApplicant = modelMapperService.forRequest()
                .map(applicantRequest,Applicant.class);

        applicant.setUpdatedDate(LocalDateTime.now());
        applicant.setFirstName(updatedApplicant.getFirstName() !=
                null ? updatedApplicant.getFirstName() : applicant.getFirstName());
        applicant.setLastName(updatedApplicant.getLastName() !=
                null ? updatedApplicant.getLastName() : applicant.getLastName());
        applicant.setUsername(updatedApplicant.getUsername() !=
                null ? updatedApplicant.getUsername() : applicant.getUsername());
        applicant.setNationalIdentity(updatedApplicant.getNationalIdentity() !=
                null ? updatedApplicant.getNationalIdentity() : applicant.getNationalIdentity());
        applicant.setDateOfBirth(updatedApplicant.getDateOfBirth() !=
                null ? updatedApplicant.getDateOfBirth() : applicant.getDateOfBirth());
        applicant.setEmail(updatedApplicant.getEmail() !=
                null ? updatedApplicant.getEmail() : applicant.getEmail());
        applicant.setAbout(updatedApplicant.getAbout() !=
                null ? updatedApplicant.getAbout() : applicant.getAbout());

        applicantRepository.save(applicant);
        UpdateApplicantResponse response = modelMapperService.forResponse()
                .map(applicant, UpdateApplicantResponse.class);

        return new SuccessDataResult<UpdateApplicantResponse>(response, "Applicant updated");
    }

    @Override
    public Result delete(int id) {
        applicantRepository.deleteById(id);
        return new SuccessResult("Applicant deleted");
    }

    @Override
    public void checkIfUserExist(String nationalIdentity) {
        User applicant = userRepository.findByNationalIdentity(nationalIdentity);
        if (applicant !=  null)
            throw new BusinessException("Applicant is already created");
    }

    @Override
    public DataResult<List<GetAllApplicantsResponse>> getAllSorted(PageDto pageDto) {
        Sort sort = Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()), pageDto.getSortBy());
        Pageable pageable = PageRequest.of(pageDto.getPageNumber(), pageDto.getPageSize(), sort);
        Page<Applicant> applicants = applicantRepository.findAll(pageable);
        List<GetAllApplicantsResponse> response = applicants.stream()
                .map(applicant -> modelMapperService.forResponse()
                        .map(applicant, GetAllApplicantsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllApplicantsResponse>>(response, "All applicants are sorted");
    }

}

