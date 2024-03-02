package com.tobeto.bootcampProject.business.requests.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlacklistRequest {
    private int id;
    private String reason;
    private LocalDate date;
    private int applicantId;
}
