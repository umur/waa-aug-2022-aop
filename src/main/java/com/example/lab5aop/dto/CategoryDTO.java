package com.example.lab5aop.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {
    private String name;
    private List<ProductDTO> products;
}
