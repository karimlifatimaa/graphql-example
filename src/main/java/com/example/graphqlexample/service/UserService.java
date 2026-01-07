package com.example.graphqlexample.service;

import com.example.graphqlexample.dto.UserCreateRequest;
import com.example.graphqlexample.dto.UserDto;
import com.example.graphqlexample.dto.UserUpdateRequest;

import java.util.List;

public interface UserService {

    UserDto createUser(UserCreateRequest request);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long id, UserUpdateRequest request);

    void deleteUser(Long id);
}


