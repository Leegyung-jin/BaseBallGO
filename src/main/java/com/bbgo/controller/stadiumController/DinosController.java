package com.bbgo.controller.stadiumController;

import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.team.StadiumDTO;
import com.bbgo.service.stadiumService.DinosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/dinos")
public class DinosController {

    private final DinosService dinosService;

    @GetMapping(value = {"", "/"})
    public String list(PageRequestDTO pageRequestDTO, Model model) {
        model.addAttribute("result", dinosService.getList(pageRequestDTO));
        return "dinos/list";
    }

    @GetMapping("/register")
    public String registerStadium(Model model) {
        return "dinos/register";
    }

    @PostMapping("/register")
    public String register(StadiumDTO stadiumDTO, RedirectAttributes redirectAttributes) {

        log.info("stadiumDTO: " + stadiumDTO);
        Long sno = dinosService.register(stadiumDTO);
        redirectAttributes.addFlashAttribute("msg", sno);

        return "redirect:/dinos";
    }

    @GetMapping({"/read", "/modify"})
    public void read(long sno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model) {
        StadiumDTO stadiumDTO = dinosService.getStadium(sno);
        model.addAttribute("dto", stadiumDTO);
    }


    @PostMapping("/modify")
    public String modify(StadiumDTO dto,
                         @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
                         RedirectAttributes redirectAttributes){
        log.info("dto: " + dto);
        dinosService.modify(dto);

        redirectAttributes.addAttribute("page", requestDTO.getPage());
        redirectAttributes.addAttribute("sno", dto.getSno());

        return "redirect:/dinos/read";
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
}
