package com.bbgo.service.stadiumService;

import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.common.PageResultDTO;
import com.bbgo.dto.team.StadiumDTO;
import com.bbgo.dto.team.StadiumImageDTO;
import com.bbgo.entity.stadium.LionsStadium;
import com.bbgo.entity.stadium.LionsStadiumImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface LionsService {

    // List
    // PageRequestDTO-파라미터, PageResultDTO-리턴 타입으로 사용
    PageResultDTO<StadiumDTO, LionsStadium> getList(PageRequestDTO requestDTO);

    // Register
    Long register(StadiumDTO dto);

    StadiumDTO getStadium(Long sno);

    // entity객체를 DTO객체로 변환
    default Map<String, Object> dtoToEntity(StadiumDTO stadiumDTO) {
        Map<String, Object> entityMap = new HashMap<>();

        String upperRow = stadiumDTO.getRow().toUpperCase();
        LionsStadium stadium = LionsStadium.builder()
                .sno(stadiumDTO.getSno())
                .base(stadiumDTO.getBase())
                .section(stadiumDTO.getSection())
                .row(upperRow)
                .num(stadiumDTO.getNum())
                .content(stadiumDTO.getContent())
                .build();
        entityMap.put("stadium", stadium);
        List<StadiumImageDTO> imageDTOList = stadiumDTO.getImageDTOList();

        // StadiumImageDTO 처리
        if (imageDTOList != null && imageDTOList.size() > 0) {
            List<LionsStadiumImage> stadiumImageList = imageDTOList.stream().map(stadiumImageDTO -> {
                LionsStadiumImage stadiumImage = LionsStadiumImage.builder()
                        .path(stadiumImageDTO.getPath())
                        .imgName(stadiumImageDTO.getImgName())
                        .uuid(stadiumImageDTO.getUuid())
                        .lionsStadium(stadium)
                        .build();
                return stadiumImage;
            }).collect(Collectors.toList());
            entityMap.put("imgList", stadiumImageList);
        }
        return entityMap;
    }

    // List
    default StadiumDTO entityToDTO(LionsStadium entity) {

        StadiumDTO stadiumDTO = StadiumDTO.builder()
                .sno(entity.getSno())
                .base(entity.getBase())
                .section(entity.getSection())
                .row(entity.getRow())
                .num(entity.getNum())
                .email("member1@aa.com")
                .nickname("ADMIN")
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();

        return stadiumDTO;
    }

    // Read
    default StadiumDTO entitiesToDTO(LionsStadium entity, List<LionsStadiumImage> stadiumImages) {
        StadiumDTO stadiumDTO = StadiumDTO.builder()
                .sno(entity.getSno())
                .base(entity.getBase())
                .section(entity.getSection())
                .row(entity.getRow())
                .num(entity.getNum())
                .content(entity.getContent())
                .email("member1@aa.com")
                .nickname("ADMIN")
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();

        List<StadiumImageDTO> stadiumImageDTOList = stadiumImages.stream().map(stadiumImage -> {
            return StadiumImageDTO.builder().imgName(stadiumImage.getImgName())
                    .path(stadiumImage.getPath())
                    .uuid(stadiumImage.getUuid())
                    .build();
        }).collect(Collectors.toList());

        stadiumDTO.setImageDTOList(stadiumImageDTOList);

        return stadiumDTO;
    }

    void modify(StadiumDTO dto);
}
