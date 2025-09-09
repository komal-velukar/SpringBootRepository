package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired private UserRepository userRepo;

    @PostMapping("/registerUser")
    public ResponseEntity<String> register(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepo.save(user);
        return ResponseEntity.ok("registered");
    }

    @PostMapping("/userLogin")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        User user = userRepo.findByUsernameAndPassword(username, password);
        return ResponseEntity.ok(user != null ? "success" : "fail");
    }
}