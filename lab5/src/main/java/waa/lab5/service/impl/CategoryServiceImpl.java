package waa.lab5.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import waa.lab5.dto.CategoryDto;
import waa.lab5.entity.Category;
import waa.lab5.helper.ExecutionTime;
import waa.lab5.repository.CategoryRepo;
import waa.lab5.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    private final ModelMapper modelMapper;

    @Override
    public List<CategoryDto> findAll() {
        var result = new ArrayList<CategoryDto>();
        categoryRepo.findAll().forEach(category -> result.add(modelMapper.map(category, CategoryDto.class)));
        return result;
    }

    @Override
    public CategoryDto findById(int id) {
        return modelMapper.map(categoryRepo.findById(id).get(), CategoryDto.class);
    }

    @Override
    public void deleteById(int id) {
        categoryRepo.deleteById(id);
    }

    @Override
    @ExecutionTime
    public void saveCategory(CategoryDto category) {
        categoryRepo.save(modelMapper.map(category, Category.class));
    }
}
