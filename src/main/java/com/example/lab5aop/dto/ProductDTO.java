package com.example.lab5aop.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private double price;
    private double rating;
    private CategoryDTO categoryDTO;
}
