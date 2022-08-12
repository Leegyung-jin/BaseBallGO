package com.bbgo.controller.stadiumController;

import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.service.stadiumService.HeroesService;
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

    private final HeroesService heroesService;

    @GetMapping(value = {"", "/"})
    public String list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("list......................" + pageRequestDTO);
        model.addAttribute("result", heroesService.getList(pageRequestDTO));
        return "heroes/list";
    }

    @GetMapping("/register")
    public String registerStadium(Model model) {
        return "heroes/register";
    }

    @GetMapping("/read")
    public String read(Model model){
        return "heroes/read";
    }
}
