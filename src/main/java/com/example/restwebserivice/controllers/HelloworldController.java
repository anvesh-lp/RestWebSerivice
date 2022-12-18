package com.example.restwebserivice.controllers;

import com.example.restwebserivice.beans.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {


    @GetMapping(path = "/helloworld")
    public String helloWorld() {
        return "Hello World";
    }


    @GetMapping(path = "/helloworld-bean")
    public HelloWorldBean helloworldBean() {
        return new HelloWorldBean("Hello world");
    }

    @GetMapping(path = "/helloworld/{name}")
    public HelloWorldBean helloWorldname(@PathVariable String name) {
        return new HelloWorldBean("Hello " + name);
    }


}
