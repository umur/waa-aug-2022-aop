package waa.lab5.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "street")
    private String street;

    @Column(name = "zip")
    private int zip;

    @Column(name = "city")
    private String city;

    @OneToOne(mappedBy = "address")
    private User user;
}
