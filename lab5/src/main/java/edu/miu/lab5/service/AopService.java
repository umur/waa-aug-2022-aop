package edu.miu.lab5.service;

import org.springframework.stereotype.Service;

@Service
public class AopService {
    public String Test(int i){
        System.out.println("Ok");
        return "Ok from method";
    }
}
