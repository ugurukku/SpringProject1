package com.example.springproject.service;
import com.example.springproject.dto.UserDto;
import com.example.springproject.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService {

    List<UserDto> findAll(int page, int count);
    UserDto findById(int id);
    void addUser(UserDto user);
    void deleteUser(int id);

    void register(User user);

}
