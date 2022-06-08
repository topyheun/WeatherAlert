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
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/join")
    public String createUser() {
        return "register"; // register 라는 view만들어야함 [이게 회원가입창이고 /join은 프론트에서 회원가입하기 버튼에 대한 action]
    }

    @PostMapping("/join")
    public String createUser(@RequestBody UserDto userDto) {
        System.out.println("userDto = " + userDto.getEmail());
        User user = modelMapper.map(userDto, User.class);
        System.out.println("user = " + user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user);

        return "redirect:/";
    }

    @GetMapping("/findpw")
    public String findPw(){
        return "findpw";
    }

    @PostMapping("/findpw") //ID E-mail 로 pw 찾기 (ID를 통해 DB에 같은 행에 있는 email과 요청으로 날라온 email 주소가 같으면 비밀번호 email로 발송)
    public String findPw(@RequestBody UserDto userDto){
        userService.findPw(userDto);

        return "redirect:/";
    }
}

