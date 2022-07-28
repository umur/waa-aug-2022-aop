package com.miu.edu.lab4springaop.dto;

import com.miu.edu.lab4springaop.entity.Product;
import com.miu.edu.lab4springaop.entity.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class ReviewDto {
    private int id;
    private String comment;

    private User user;

    private Product product;
}
