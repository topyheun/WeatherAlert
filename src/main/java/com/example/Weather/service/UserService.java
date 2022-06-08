package com.example.Weather.service;


import com.example.Weather.dto.UserDto;
import com.example.Weather.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void createUser(User user);
    void findPw(UserDto userDto);

}