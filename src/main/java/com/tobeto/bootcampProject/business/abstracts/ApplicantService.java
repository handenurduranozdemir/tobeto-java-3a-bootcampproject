package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.applicant.ApplicantRequest;
import com.tobeto.bootcampProject.entities.Applicant;
import java.util.List;

public interface ApplicantService {
    List<Applicant> getAllApplicants();
    //void delete(int id);
    //void update(ApplicantRequest request);
}
