package com.umuttepe.restexample.controller;

import com.umuttepe.restexample.dto.user.UserDto;
import com.umuttepe.restexample.entity.User;
import com.umuttepe.restexample.exception.user.UserNotFoundException;
import com.umuttepe.restexample.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        List<User> users = userService.getUsers();
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) throws UserNotFoundException {
        User user = userService.getUser(id);
        return convertToDto(user);
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto) {
        User user = convertToEntity(userDto);
        return convertToDto(userService.saveUser(user));
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) throws UserNotFoundException {
        User oldUser = userService.getUser(id);
        User user = convertToEntity(userDto);
        user.setId(oldUser.getId());
        return convertToDto(userService.saveUser(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) throws UserNotFoundException {
        userService.deleteUser(id);
    }

    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private User convertToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

}
