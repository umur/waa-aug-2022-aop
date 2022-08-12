package edu.miu.aop_lab.dto;

import com.fasterxml.jackson.databind.DatabindException;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class ActivityLogDto {

    private int id;
    private LocalDate date ;
    private String operation;
    private long duration;

    public ActivityLogDto(LocalDate date, String operation, long duration) {
        this.date = date;
        this.operation = operation;
        this.duration = duration;
    }
}
