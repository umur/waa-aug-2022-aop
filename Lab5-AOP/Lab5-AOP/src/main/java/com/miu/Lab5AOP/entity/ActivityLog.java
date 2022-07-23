package com.miu.Lab5AOP.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ActivityLog {
    @Id
    @GeneratedValue
    private int id;
    @Temporal(TemporalType.TIME)
    private Date date;
    private String operation;
    private long duration;
}
