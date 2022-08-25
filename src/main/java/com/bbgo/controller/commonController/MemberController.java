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

import javax.servlet.http.HttpServletRequest;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping(value = "/checkEmail")
    @ResponseBody
    public int checkEmail(@RequestParam("username") String username) {
        int result = memberService.checkEmail(username);
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
    public String login(HttpServletRequest request, Model model){
        /**
         * 이전 페이지로 이동하기 위해 Referer 헤더값을 세션의 prevPage attribute로 저장한다.
         * Config > auth > CustomAuthSuccessHandler 참고

        String uri = request.getHeader("Referer");
        if (uri != null && !uri.contains("/login")) {   // uri가 null이면 session을 저장하지 않는다.
            request.getSession().setAttribute("prevPage", uri);
        }

         */
        return "common/login";
    }
}
