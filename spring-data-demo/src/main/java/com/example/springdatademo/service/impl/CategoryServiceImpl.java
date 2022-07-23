package com.example.springdatademo.service.impl;

import com.example.springdatademo.dto.CategoryDto;
import com.example.springdatademo.entity.Category;
import com.example.springdatademo.annotation.ExecutionTime;
import com.example.springdatademo.repository.CategoryRepository;
import com.example.springdatademo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @ExecutionTime
    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(category -> categoryToDto(category)).collect(Collectors.toList());
    }

    @ExecutionTime
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryToDto(categoryRepository.save(dtoToCategory(categoryDto)));
    }

    @ExecutionTime
    @Override
    public CategoryDto findById(int categoryId) {
        return categoryToDto(categoryRepository.findById(categoryId).orElse(null));
    }

    @ExecutionTime
    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        return categoryToDto(categoryRepository.save(dtoToCategory(categoryDto)));
    }

    @ExecutionTime
    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }

    private CategoryDto categoryToDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    private Category dtoToCategory(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }
}
