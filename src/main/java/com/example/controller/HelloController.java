package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController ;


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Привет, Spring Boot!";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye() {
        return "До свидания, Spring Boot!";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Привет, %s!".formatted(name);
    }

    @GetMapping("/person")
    public String getPersonInfo(@RequestParam String name, @RequestParam int age) {
        return "Вас зовут %s, вам %d лет".formatted(name, age);
    }

}
