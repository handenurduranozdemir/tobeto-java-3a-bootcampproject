package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.ApplicantService;
import com.tobeto.bootcampProject.dataacces.ApplicantRepository;
import com.tobeto.bootcampProject.entities.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantManager implements ApplicantService {

    private final ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantManager(ApplicantRepository applicantRepository) {
        this.applicantRepository =applicantRepository;
    }

    @Override
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }


}

