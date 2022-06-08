package com.example.Weather.controller;

import com.example.Weather.dto.UserDto;
import com.example.Weather.model.User;
import com.example.Weather.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/join")
    public String createUser() {
        return "register"; // register 라는 view만들어야함 [이게 회원가입창이고 /join은 프론트에서 회원가입하기 버튼에 대한 action]
    }

    @PostMapping("/join")
    public String createUser(UserDto userDto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDto, User.class);
        System.out.println("3333");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("4444");
        userService.createUser(user);

        return "redirect:/";
    }
}

