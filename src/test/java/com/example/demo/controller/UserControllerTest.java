package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {

    private UserService userService;
    private UserController userController;

    @BeforeEach
    public void setUp() {
        userService = mock(UserService.class);
        userController = new UserController(userService);
    }

    @Test
    public void testListUsers() {
        List<User> fakeUsers = List.of(
                new User(1L, "admin", "ADMIN"),
                new User(2L, "user", "USER")
        );

        when(userService.getAllUsers()).thenReturn(fakeUsers);

        List<User> result = userController.listUsers();

        assertEquals(2, result.size());
        assertEquals("admin", result.get(0).getUsername());
        verify(userService, times(1)).getAllUsers();
    }
}