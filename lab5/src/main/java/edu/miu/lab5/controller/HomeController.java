package edu.miu.lab5.controller;

import edu.miu.lab5.service.AopService;
import edu.miu.lab5.service.Service2;
import edu.miu.lab5.service.nested.Service3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired AopService aopService;
    @Autowired
    Service2 aopService2;
    @Autowired
    Service3 aopService3;

    @GetMapping
    public ResponseEntity<String> GetString(){

        return ResponseEntity.status(200).body(aopService.Test(5));
    }

    @GetMapping("/2")
    public ResponseEntity<String> GetString2(){

        return ResponseEntity.status(200).body(aopService2.Test(5));
    }

    @GetMapping("/3")
    public ResponseEntity<String> GetString3(){

        return ResponseEntity.status(200).body(aopService3.Test(5));
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> GetString(@PathVariable int id){

        return ResponseEntity.status(200).body(aopService.Test(id));
    }
}
