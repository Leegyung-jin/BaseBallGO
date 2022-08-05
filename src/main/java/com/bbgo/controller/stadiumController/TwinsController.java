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
@RequestMapping("/twins")
public class TwinsController {

    @GetMapping(value = {"", "/"})
    public String main(Model model) {
        return "team/twins";
    }
}
