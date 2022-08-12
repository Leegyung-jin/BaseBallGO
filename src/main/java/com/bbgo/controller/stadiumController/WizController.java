package com.bbgo.controller.stadiumController;

import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.service.stadiumService.WizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/wiz")
public class WizController {

    private final WizService wizService;

    @GetMapping(value = {"", "/"})
    public String list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("list......................" + pageRequestDTO);
        model.addAttribute("result", wizService.getList(pageRequestDTO));
        return "wiz/list";
    }
}
