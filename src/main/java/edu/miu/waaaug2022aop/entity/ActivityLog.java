package edu.miu.waaaug2022aop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private LocalDate date;
    private String operation;
    private double duration;
}
