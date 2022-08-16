package com.bbgo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
//@RequestMapping("/bbgo")
public class MainController {

    @GetMapping("/main")
    public String main(Model model) {
        return "/index";
    }

    
    @GetMapping("/stadium")
    public String stadium(Model model) {
        return "common/stadium";
    }

    // 구단 정보 알아보기
    @GetMapping("/team")
    public String team(Model model) {
        return "common/team";
    }
}
