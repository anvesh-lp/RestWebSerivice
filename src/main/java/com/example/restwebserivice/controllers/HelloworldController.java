package com.example.restwebserivice.controllers;

import com.example.restwebserivice.beans.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@RestController
public class HelloworldController {


    @GetMapping(path = "/helloworld")
    public String helloWorld() {
        return "Hello World";
    }


    @GetMapping(path="/helloworld-bean")
    public HelloWorldBean helloworldBean(){
        return new HelloWorldBean("Hello world");
    }


}
