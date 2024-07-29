package com.ali.java.todo.controller;


import com.ali.java.todo.model.User;
import com.ali.java.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@Slf4j
@Profile("dev")
@RequestMapping("/api/v1/user")
public class UserController  {

    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user) {
        return userService.update(user);
    }


    @GetMapping
    public List<User>getAllUsers() {
        return userService.findAll();
    }


    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        log.info("this is simple logging using slf4j");
        log.warn("a record is getting deleted");
        return userService.delete(id);

    }
}
