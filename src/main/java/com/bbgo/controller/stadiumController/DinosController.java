package com.bbgo.controller.stadiumController;

import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.service.stadiumService.DinosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/dinos")
public class DinosController {

    private final DinosService dinosService;

    @GetMapping(value = {"", "/"})
    public String list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("list......................" + pageRequestDTO);
        model.addAttribute("result", dinosService.getList(pageRequestDTO));
        return "dinos/list";
    }
}
