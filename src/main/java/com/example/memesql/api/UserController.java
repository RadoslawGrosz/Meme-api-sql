package com.example.memesql.api;

import com.example.memesql.models.User;
import com.example.memesql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/user")
@RestController
@CrossOrigin()
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestHeader("authorization") String token) {
        return userService.logIn(token);
    }
}

