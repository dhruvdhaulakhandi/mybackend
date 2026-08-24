package co.example.mybackend;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class HelloController {

    @GetMapping("/api/message")
    public String getMessage() {
        return "Shabaash! Ye message Spring Boot Backend se aaya hai 🎉";
    }
}