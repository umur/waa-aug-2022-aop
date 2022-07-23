package com.example.lab5aop.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String comment;

    @ManyToOne
    private User user;
}
