package com.example.springdatademo.service;

import com.example.springdatademo.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto save(CategoryDto categoryDto);
    CategoryDto findById(int categoryDto);
    CategoryDto update(CategoryDto categoryDto);
    void delete(int id);
}
