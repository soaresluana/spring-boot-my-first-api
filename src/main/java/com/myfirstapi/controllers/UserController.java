package com.myfirstapi.controllers;

import com.myfirstapi.model.User;
import com.myfirstapi.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id) {
        Optional<User> userFind = this.userRepository.findById(id);

        return userFind.orElse(null);
    }

    @PostMapping("/")
    public User user(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @GetMapping("/list")
    public List<User> list() {
        return this.userRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public List<User> listMoreThan(@PathVariable("id") Long id) {
        return this.userRepository.findByIdGreaterThan(id);
    }

    @GetMapping("/findByName/{name}")
    public List<User> findByName(@PathVariable("name") String name) {
        return this.userRepository.findByName(name);
    }
}
