package com.example.Weather.service.impl;

import com.example.Weather.dto.UserDto;
import com.example.Weather.model.User;
import com.example.Weather.repository.UserRepository;
import com.example.Weather.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void createUser(User user){
        userRepository.save(user);
    }

    @Override
    public void findPw(UserDto userDto) {
        //userDto에 nickname, username 2개 값이 들어왔을 때,
        //nickname, username 에 일치하는 email로 임시 비밀번호를 발급하는 api

        userRepository.findEmailByUsernameAndNickname(userDto.getUsername(), userDto.getNickname());
    }
}
