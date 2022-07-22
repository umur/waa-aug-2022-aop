package edu.miu.lab5.service;

import edu.miu.lab5.dto.CategoryDto;
import edu.miu.lab5.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(CategoryDto categoryDto);

    void delete(int id);

    Category getById(int id);

    List<Category> getAll();

    Category updateCategory(Category category);
}
