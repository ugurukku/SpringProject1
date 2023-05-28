package com.example.springproject.controller;

import com.example.springproject.dto.UserDto;
import com.example.springproject.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    UserController controller;

    @Mock
    UserService service;

    @BeforeEach
    void init() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    void findAll() {
        List<UserDto> expected = List.of(
                new UserDto("NAME1", 1),
                new UserDto("NAME2", 2),
                new UserDto("NAME3", 3)
                );

        when(service.findAll(0,1)).thenReturn(expected);

        ResponseEntity<List<UserDto>> response = controller.findAll(0, 1);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(expected,response.getBody());


    }

    @Test
    void findById() {


    }

    @Test
    void addUser() {
        UserDto request = new UserDto("NAME3", 3);

        doNothing().when(service).addUser(request);

        ResponseEntity<Void> response = controller.addUser(request);

        assertEquals(HttpStatus.CREATED,response.getStatusCode());

    }

    @Test
    void deleteUser() {
    }
}