package com.tobeto.bootcampProject.business.requests.update;

import java.time.LocalDateTime;

public class UpdateBlacklistRequest {
    private int id;
    private String reason;
    private LocalDateTime date;
    private int applicantId;
}
