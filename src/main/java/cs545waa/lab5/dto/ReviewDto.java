package cs545waa.lab5.dto;

import cs545waa.lab5.entity.Product;
import cs545waa.lab5.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private int id;
    private String comment;
    private User user;
    private Product product;
}
