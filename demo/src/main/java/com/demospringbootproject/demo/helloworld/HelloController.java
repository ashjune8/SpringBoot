package com.demospringbootproject.demo.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path="/helloworld")
    public String getString(){

        return "Hello there!!";

    }
    @GetMapping(path="/helloworldbean")
    public StringBean getStringBean(){
        return new StringBean("Hello Bean!!");
    }
    
}
