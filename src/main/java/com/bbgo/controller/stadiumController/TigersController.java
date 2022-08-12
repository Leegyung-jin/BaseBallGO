package com.bbgo.controller.stadiumController;

import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.service.stadiumService.TigersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/tigers")
public class TigersController {

    private final TigersService tigersService;

    @GetMapping(value = {"", "/"})    public String list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("list......................" + pageRequestDTO);
        model.addAttribute("result", tigersService.getList(pageRequestDTO));
        return "tigers/list";
    }
}
