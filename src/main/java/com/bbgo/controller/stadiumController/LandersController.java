package com.bbgo.controller.stadiumController;

import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.team.StadiumDTO;
import com.bbgo.entity.Stadium;
import com.bbgo.service.stadiumService.LandersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        return "landers/list";
    }

    @GetMapping("/register")
    public String registerStadium(Model model) {
        return "landers/register";
    }

    @PostMapping("/register")
    public String register(StadiumDTO stadiumDTO, RedirectAttributes redirectAttributes) {

        log.info("C>stadiumDTO: " + stadiumDTO);
        Long sno = landersService.register(stadiumDTO);
        log.info("SNO: " + sno);
        redirectAttributes.addFlashAttribute("msg", sno);

        return "redirect:/landers";
    }

    @GetMapping({"/read", "/modify"})
    public void read(long sno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model) {
        log.info("sno: " + sno);
        StadiumDTO stadiumDTO = landersService.getStadium(sno);
        model.addAttribute("dto", stadiumDTO);
    }
}
