package com.miu.edu.lab4springaop.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToOne
    @JsonIgnoreProperties("reviews")
    private Product product;
}
