package com.example.graphqlexample.resolver;

import com.example.graphqlexample.dto.*;
import com.example.graphqlexample.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserMutationResolver {

    private final UserService userService;

    public UserMutationResolver(UserService userService) {
        this.userService = userService;
    }

    @MutationMapping // schema.graphqls-dəki 'createUser' ilə uyğunlaşır
    public UserDto createUser(@Argument UserInput input) {
        UserCreateRequest request = new UserCreateRequest(
                input.getFirstName(),
                input.getLastName(),
                input.getEmail()
        );
        return userService.createUser(request);
    }

    @MutationMapping
    public UserDto updateUser(@Argument String id, @Argument UserUpdateInput input) {
        UserUpdateRequest request = new UserUpdateRequest(
                input.getFirstName(),
                input.getLastName(),
                input.getEmail()
        );
        return userService.updateUser(Long.parseLong(id), request);
    }

    @MutationMapping
    public Boolean deleteUser(@Argument String id) {
        userService.deleteUser(Long.parseLong(id));
        return true;
    }
}