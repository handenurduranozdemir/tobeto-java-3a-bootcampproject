package com.tobeto.bootcampProject.business.responses.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlacklistResponse {
    private int id;
    private String reason;
    private LocalDate date;
    private int applicantId;
}
