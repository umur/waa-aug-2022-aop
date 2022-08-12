package edu.miu.aop_lab.controller;

import edu.miu.aop_lab.annotations.ExecutionTime;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @ExecutionTime
    @GetMapping
    public void getAll()
    {
        System.out.println("Get all is called from controller.........");
    }

    @ExecutionTime
    @GetMapping("/one")
    public void getOne()
    {
        System.out.println("Get one method is called....");
    }

    @PostMapping("/post")
    public void postMappingMethod(@RequestHeader Map<String , String> headers )
    {
        System.out.println("Post method is called ........" );
    }
}
