package com.bbgo.controller.stadiumController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/heroes")
public class HeroesController {

    @GetMapping(value = {"", "/"})
    public String main(Model model) {
        return "team/heroes";
    }

    @GetMapping("/register")
    public String registerStadium(Model model) {
        return "team/heroesRegister";
    }

}
