package com.tobeto.bootcampProject.business.requests.create;

import java.time.LocalDateTime;

public class CreateBlacklistRequest {
    private String reason;
    private LocalDateTime date;
    private int applicantId;
}
