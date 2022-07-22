package edu.miu.waaaug2022aop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityLogDto {
    private LocalDate date;
    private String operation;
    private double duration;
}
