package com.bbgo.controller.stadiumController;

import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.team.LandersDTO;
import com.bbgo.service.stadiumService.LandersService;
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

    private final LandersService landersService;

    @GetMapping(value = {"", "/"})
    public String list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("list......................" + pageRequestDTO);
        model.addAttribute("result", landersService.getList(pageRequestDTO));
        return "team/landers";
    }

    @GetMapping("/register")
    public String registerStadium(Model model) {
        return "team/landersRegister";
    }

    @PostMapping("/register")
    public String register(LandersDTO landersDTO, RedirectAttributes redirectAttributes) {
        return "/landers";
    }


}
