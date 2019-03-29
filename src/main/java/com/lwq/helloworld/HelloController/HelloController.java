package com.lwq.helloworld.HelloController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/helloworld")
    public String HelloWorld(){
        System.out.println("搭建springboot成功");
        return "Hello World";
    }
}
