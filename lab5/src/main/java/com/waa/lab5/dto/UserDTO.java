package com.waa.lab5.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private AddressDTO address;
}
