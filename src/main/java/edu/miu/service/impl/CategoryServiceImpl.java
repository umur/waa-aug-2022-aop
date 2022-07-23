package edu.miu.service.impl;

import edu.miu.annotation.ExecutionTime;
import edu.miu.dto.CategoryDto;
import edu.miu.entity.Category;
import edu.miu.repository.CategoryRepository;
import edu.miu.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    @ExecutionTime
    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(this::categoryToDto).collect(Collectors.toList());
    }

    @ExecutionTime
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        categoryRepository.save(dtoToCategory(categoryDto));
        return categoryDto;
    }

    @ExecutionTime
    @Override
    public CategoryDto getOne(int categoryId) {
        return categoryRepository.findById(categoryId).map(this::categoryToDto).orElse(null);
    }

    @Override
    public void remove(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    private CategoryDto categoryToDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    private Category dtoToCategory(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }

}
