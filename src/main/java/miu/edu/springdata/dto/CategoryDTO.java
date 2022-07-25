package miu.edu.springdata.dto;

import lombok.Data;
import miu.edu.springdata.entity.Product;

import java.util.List;

@Data
public class CategoryDTO {

    private long id;

    private String name;

    private List<ProductDTO> products;
}
