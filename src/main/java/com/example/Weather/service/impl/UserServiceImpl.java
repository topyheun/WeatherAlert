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
        System.out.println("여기까지는 되냐");

        userRepository.save(user);

    }

    @Override
    public void findPw(UserDto userDto) {
        //userDto에 email id 2개 값이 들어왔을 때, DB에 id가 있으면 id에 해당되는 email과 요청으로온 email이 일치하는지 확인 후 임시비밀번호 발급
        //DB에 id가 없으면 "등록되지 않은 id라고 출력
        if (userRepository.findById(userDto.getId()).getEmail() = userDto.getEmail()){
            //임시비밀번호 발송
        }
    }
}
//        if(userDto.getEmail() = userRepository.findById(userDto.getId())){
//            //이메일 보내기
//        }
//        else {
//            System.out.println("다시입력해주세요");
//        }
