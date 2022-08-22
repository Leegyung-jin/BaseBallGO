package com.bbgo.controller.commonController;

import com.bbgo.dto.common.MemberDTO;
import com.bbgo.service.signUpService.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private MemberService memberService;

    @GetMapping("/signup")
    public String signUp(Model model) {
        return "common/signup";
    }

    @PostMapping("/signup")
    public String signUp(MemberDTO memberDTO, RedirectAttributes redirectAttributes) {
        log.info("MemberDTO: " + memberDTO);
        Long mno = memberService.signUp(memberDTO);
        log.info("MNO: " + mno);
        redirectAttributes.addFlashAttribute("msg", mno);

        return "redirect:/main";
    }

    @GetMapping("/login")
    public void login(){
        log.info("login...........");
    }
}
