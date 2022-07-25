package miu.edu.springdata.service;

import miu.edu.springdata.dto.ProductDTO;
import miu.edu.springdata.dto.ReviewDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAll();

    ProductDTO findById(long id);

    List<ProductDTO> findWithMinPrice(double minPrice);

    List<ProductDTO> findByCatWithMaxPrice(String cat, double maxPrice);

    List<ProductDTO> findByKeyword(String keyword);

    List<ReviewDTO> findReviews(long productId);

    ProductDTO addProduct(ProductDTO productDTO);

    ReviewDTO addReview(long productId, ReviewDTO reviewDTO);

}
