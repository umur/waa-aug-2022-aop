package miu.edu.springaoplab5.contrtollers;

import miu.edu.springaoplab5.annotations.ExecutionTime;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/tests")
public class TestController {

    @PostMapping
    @ExecutionTime
    public String post(@RequestHeader Map<String, String> headers){
        return "All";
    }

}
