package com.example.demo.controller;

import com.example.demo.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/greet")
public class GreetingsController {

    private final GreetingService greetingService;

    public GreetingsController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/{name}")
    public String greet(@PathVariable String name) {
        System.out.println("Print statement");
        return greetingService.getGreeting(name);                // http://localhost:8080/api/greet/John
    }
    
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from controller"; // Duplicate block      //http://localhost:8080/api/greet/hello
    }

    @GetMapping("/hi")
    public String sayHi() {
        return "Hello from controller"; // Duplicate block (to be caught by Sonar)
    }
}
