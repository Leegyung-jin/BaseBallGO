package com.bbgo.service.stadiumService;

import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.common.PageResultDTO;
import com.bbgo.dto.team.StadiumDTO;
import com.bbgo.dto.team.StadiumImageDTO;
import com.bbgo.entity.Stadium;
import com.bbgo.entity.StadiumImage;
import com.bbgo.entity.Team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface LandersService {

    // List
    // PageRequestDTO-파라미터, PageResultDTO-리턴 타입으로 사용
    PageResultDTO<StadiumDTO, Stadium> getList(PageRequestDTO requestDTO);

    // entity객체를 DTO객체로 변환
//    default Stadium dtoToEntity(StadiumDTO dto) {
//    Team team = Team.builder().sName(dto.getSName()).build();
//
//    Stadium entity = Stadium.builder()
//            .sno(dto.getSno())
//            .team(team)
//            .base(dto.getBase())
//            .section(dto.getSection())
//            .row(dto.getRow())
//            .num(dto.getNum())
//            .build();
//        return entity;
//}
    default Map<String, Object> dtoToEntity(StadiumDTO stadiumDTO) {
        Map<String, Object> entityMap = new HashMap<>();

        Team team = Team.builder().sName(stadiumDTO.getSName()).build();
        Stadium stadium = Stadium.builder()
                .sno(stadiumDTO.getSno())
                .team(team)
                .base(stadiumDTO.getBase())
                .section(stadiumDTO.getSection())
                .row(stadiumDTO.getRow())
                .num(stadiumDTO.getNum())
                .content(stadiumDTO.getContent())
                .build();
        entityMap.put("stadium", stadium);

        List<StadiumImageDTO> imageDTOList = stadiumDTO.getImageDTOList();
        System.out.println("=============================== StadiumDTO- " + stadiumDTO);
        System.out.println("=============================== imageDTOList- " + imageDTOList);

        // StadiumImageDTO 처리
        if (imageDTOList != null && imageDTOList.size() > 0) {
            List<StadiumImage> stadiumImageList = imageDTOList.stream().map(stadiumImageDTO -> {
                StadiumImage stadiumImage = StadiumImage.builder()
                        .path(stadiumImageDTO.getPath())
                        .imgName(stadiumImageDTO.getImgName())
                        .uuid(stadiumImageDTO.getUuid())
                        .stadium(stadium)

                        .build();
                return stadiumImage;
            }).collect(Collectors.toList());

            System.out.println("========================== stadiumImage= " + stadiumImageList);
            entityMap.put("imgList", stadiumImageList);
        }

        return entityMap;
    }

    default StadiumDTO entityToDto(Stadium entity) {

        StadiumDTO dto = StadiumDTO.builder()
                .sno(entity.getSno())
//                .sName(entity.getTeam().getSName())
                .sName("인천 SSG랜더스필드")
                .base(entity.getBase())
                .section(entity.getSection())
                .row(entity.getRow())
                .num(entity.getNum())
                .email("member1@aa.com")
                .nickname("ADMIN")
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }

    // Register
    Long register(StadiumDTO dto);

}
