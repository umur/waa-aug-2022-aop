package edu.miu.lab5.service.nested;

import edu.miu.lab5.helper.ExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class Service3 {
    @ExecutionTime
    public String Test(int i){
        System.out.println("Ok");
        return "Ok from method 3";
    }
}
