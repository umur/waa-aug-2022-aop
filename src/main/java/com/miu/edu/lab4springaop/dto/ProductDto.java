package com.miu.edu.lab4springaop.dto;

import com.miu.edu.lab4springaop.entity.Category;
import com.miu.edu.lab4springaop.entity.Review;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ProductDto {

    private int id;
    private String name;
    private double price;
    private double rating;
    private Category category;

    private List<Review> reviews;
}
