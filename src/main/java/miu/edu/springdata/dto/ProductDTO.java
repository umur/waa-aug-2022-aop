package miu.edu.springdata.dto;

import lombok.Data;
import miu.edu.springdata.entity.Category;
import miu.edu.springdata.entity.Review;

import java.util.List;

@Data
public class ProductDTO {

    private long id;

    private String name;

    private double price;

    private String rating;

    private CategoryDTO category;

    private List<ReviewDTO> reviews;
}
