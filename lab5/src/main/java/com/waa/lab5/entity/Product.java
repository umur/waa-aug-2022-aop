package com.waa.lab5.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private int price;
    private int rating;

    @ManyToOne()
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
