package com.example.springproject.controller;

import com.example.springproject.dto.UserDto;
import com.example.springproject.maneger.UserManager;
import com.example.springproject.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    private final Logger logger;

    public UserController(UserService service) {
        this.service = service;
        this.logger = LoggerFactory.getLogger(UserController.class);
    }

    @GetMapping
    ResponseEntity<List<UserDto>> findAll(@RequestParam(name = "page") int page, @RequestParam(name = "count") int count) {
        logger.info("Find all request accepted");
        return ResponseEntity.ok(service.findAll(page,count));
    }

    @GetMapping("/{id}")
    ResponseEntity<UserDto> findById(@PathVariable int id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/add")
    ResponseEntity<Void> addUser(@Valid @RequestBody UserDto user) {
        service.addUser(user);
        return ResponseEntity.created(URI.create("/api/users")).build();
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        return ResponseEntity.status(200).build();
    }
}