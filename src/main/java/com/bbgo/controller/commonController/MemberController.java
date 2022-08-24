package com.bbgo.controller.commonController;

import com.bbgo.dto.common.MemberDTO;
import com.bbgo.service.MemberService.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/checkEmail")
    @ResponseBody
    public int checkEmail(@RequestParam("email") String email) {
        int result = memberService.checkEmail(email);
        return result;
    }

    @GetMapping("/signup")
    public String signUp(Model model) {
        return "common/signup";
    }

    @PostMapping("/signup")
    public String signUp(MemberDTO memberDTO, RedirectAttributes redirectAttributes) {
        log.info("MemberDTO: " + memberDTO);
        Long mno = memberService.signUp(memberDTO);
        redirectAttributes.addFlashAttribute("msg", mno);

        return "redirect:/main";
    }

    @GetMapping("/login")
    public void login(){
        log.info("login...........");
    }
}
