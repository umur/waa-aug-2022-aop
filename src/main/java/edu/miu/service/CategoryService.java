package edu.miu.service;


import edu.miu.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto getOne(int categoryId);

    void remove(int categoryId);
}
