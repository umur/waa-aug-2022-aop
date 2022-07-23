package com.example.springdatademo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private float rating;
    private double price;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;
}
