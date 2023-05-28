package com.example.springproject.controller;


import com.example.springproject.dto.RegisterRequest;
import com.example.springproject.entity.User;
import com.example.springproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public record AuthController(
        UserService service
) {

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest request) {
        service.register(User.builder().email(request.email()).password(request.password()).build());
        return ResponseEntity.ok(null);
    }

}
