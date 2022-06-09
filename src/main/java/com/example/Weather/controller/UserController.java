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
        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user);

        return "redirect:/";
    }

    @GetMapping("/findpw")
    public String findPwGet(){
        return "findpw";
    }

    @PostMapping("/findpw") //username 이랑 nickname 으로 email 찾아서 email로 메일 전송 & 전송했다는 알림
    public void findPwPost(@RequestBody UserDto userDto){
        userService.findPw(userDto);
    }

    @PostMapping("/idCheck")
    void idCheckPost(@RequestBody UserDto userDto){
//        userService.idCheck(userDto); //아이디 확인에 대한 button action 처리
    }
}

