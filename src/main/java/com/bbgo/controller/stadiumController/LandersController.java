package com.bbgo.controller.stadiumController;

import com.bbgo.config.auth.PrincipalDetail;
import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.team.StadiumDTO;
import com.bbgo.service.stadiumService.LandersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
    public String register(StadiumDTO stadiumDTO, RedirectAttributes redirectAttributes, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        log.info("stadiumDTO: " + stadiumDTO);
        Long sno = landersService.register(stadiumDTO, principalDetail);
        redirectAttributes.addFlashAttribute("msg", sno);

        return "redirect:/landers";
    }

    @GetMapping({"/read"})
    public void read(long sno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        log.info("sno: " + sno);
        Long principalMno = principalDetail.getMno();
        StadiumDTO stadiumDTO = landersService.getStadium(sno, principalDetail);
        model.addAttribute("dto", stadiumDTO);
    }

    @GetMapping({ "/modify"})
    public String modify(long sno,
                         @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
                         Model model, @AuthenticationPrincipal PrincipalDetail principalDetail,
                         RedirectAttributes redirectAttributes) {
        Long principalMno = principalDetail.getMno();
        StadiumDTO stadiumDTO = landersService.getModify(sno);
        if (stadiumDTO.getMno() == principalMno) {
            model.addAttribute("dto", stadiumDTO);
            return "/landers/modify";
        } else {
            redirectAttributes.addFlashAttribute("msg", "접근할 수 없습니다.");
            return "/common/errorPage";
        }
    }

    @PostMapping("/modify")
    public String modify(StadiumDTO dto,
                         @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
                         RedirectAttributes redirectAttributes){
        log.info("dto: " + dto);
        landersService.modify(dto);
        redirectAttributes.addAttribute("page", requestDTO.getPage());
        redirectAttributes.addAttribute("sno", dto.getSno());
        return "redirect:/landers/read";
    }


    @Value("${com.bbgo.upload.path}")
    private String uploadPath;
    @PostMapping("/removeFile")
    public ResponseEntity<Boolean> modifyRemoveFile(String fileName, Long ino, Long sno){
        String srcFileName = null;
        try {
            srcFileName = URLDecoder.decode(fileName, "UTF-8");
            File file = new File(uploadPath + File.separator + srcFileName);
            System.out.println("file= " + file);
            boolean result = file.delete();

            // 섬네일 파일도 함께 삭제한다.
            File thumbnail = new File(file.getParent(), "s_" + file.getName());
            System.out.println("thumbnail= " + thumbnail);
            result = thumbnail.delete();

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete")
    public String delete(Long sno, RedirectAttributes redirectAttributes) {
        log.info("sno: " + sno);
        landersService.delete(sno);
        redirectAttributes.addFlashAttribute("msg", sno);
        return "redirect:/landers";
    }
}