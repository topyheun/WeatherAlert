package com.example.Weather.dto;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String password;
    private String email;
}

//    @Builder
//    public UserDto(String id, String password, String email){
//        this.id = id;
//        this.password = password;
//        this.email = email;
//    }
//
//    public User toEntity(){
//        return User.builder()
//                .id(id)
//                .password(password)
//                .email(email)
//                .build();
//    }
