package com.tobeto.bootcampProject.business.responses.delete;

import java.time.LocalDate;

public class DeleteBlacklistResponse {
    private int id;
    private String reason;
    private LocalDate date;
    private int applicantId;
    private String applicantFirstName;
    private String applicantLastName;
}
