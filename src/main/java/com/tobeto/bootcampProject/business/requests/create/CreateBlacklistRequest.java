package com.tobeto.bootcampProject.business.requests.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlacklistRequest {
    private String reason;
    private LocalDate date;
    private int applicantId;
}
