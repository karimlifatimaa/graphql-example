package com.example.graphqlexample.resolver;

import com.example.graphqlexample.dto.UserDto;
import com.example.graphqlexample.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserQueryResolver {

    private final UserService userService;

    public UserQueryResolver(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping // schema.graphqls-dəki 'getUserById' ilə uyğunlaşır
    public UserDto getUserById(@Argument String id) {
        return userService.getUserById(Long.parseLong(id));
    }

    @QueryMapping // schema.graphqls-dəki 'getAllUsers' ilə uyğunlaşır
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}