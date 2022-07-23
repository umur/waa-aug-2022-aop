package com.waa.lab5.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToOne()
    private Address address;
}
