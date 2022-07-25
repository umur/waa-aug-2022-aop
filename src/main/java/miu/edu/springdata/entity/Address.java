package miu.edu.springdata.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String street;

    private String zip;

    private String city;

    @OneToOne(mappedBy = "address")
    private User user;
}
