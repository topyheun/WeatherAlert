package com.example.Weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home"; //home 이라는 페이지 만들면 루트경로가 홈페이지다.
    }
}
