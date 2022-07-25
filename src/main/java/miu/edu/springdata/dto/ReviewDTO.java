package miu.edu.springdata.dto;

import lombok.Data;
import miu.edu.springdata.entity.Product;
import miu.edu.springdata.entity.User;

@Data
public class ReviewDTO {

    private long id;

    private String comment;

    private User user;

//    private Product product;
}
