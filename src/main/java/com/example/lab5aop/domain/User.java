package com.example.lab5aop.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Customer")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToOne
    private Address addresses;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

}
