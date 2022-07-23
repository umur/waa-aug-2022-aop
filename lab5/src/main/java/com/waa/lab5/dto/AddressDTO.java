package com.waa.lab5.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private int id;
    private String street;
    private int zip;
    private String city;
}
