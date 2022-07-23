package cs545waa.lab5.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;
    private double price;

    @JsonManagedReference
    @ManyToOne
    private Category category;

    @JsonBackReference
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
