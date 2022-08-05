package com.bbgo.controller.stadiumController;

import com.bbgo.dto.team.LandersDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/landers")
public class LandersController {

    @GetMapping(value = {"","/"})
    public String main(Model model) {
        return "team/landers";
    }

    @GetMapping("/register")
    public String registerStadium(Model model) {
        return "team/landersRegister";
    }

    @PostMapping("/register")
    public String register(LandersDTO landersDTO, RedirectAttributes redirectAttributes) {
        System.out.println("2222222222222222222222222");

        log.info("landersDTO: " + landersDTO);
//        Long tno = landersService.register(landersDTO);
//        redirectAttributes.addFlashAttribute("msg", tno);

        return "/landers";
    }
}
