package com.bbgo.service.stadiumService;

import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.common.PageResultDTO;
import com.bbgo.dto.team.StadiumDTO;
import com.bbgo.dto.team.StadiumImageDTO;
import com.bbgo.entity.stadium.TigersStadium;
import com.bbgo.entity.stadium.TigersStadiumImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface TigersService {

    // List
    // PageRequestDTO-파라미터, PageResultDTO-리턴 타입으로 사용
    PageResultDTO<StadiumDTO, TigersStadium> getList(PageRequestDTO requestDTO);

    // Register
    Long register(StadiumDTO dto);

    StadiumDTO getStadium(Long sno);

    // entity객체를 DTO객체로 변환
    default Map<String, Object> dtoToEntity(StadiumDTO stadiumDTO) {
        Map<String, Object> entityMap = new HashMap<>();

        String upperRow = stadiumDTO.getRow().toUpperCase();
        TigersStadium stadium = TigersStadium.builder()
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
        List<TigersStadiumImage> stadiumImageList = imageDTOList.stream().map(stadiumImageDTO -> {
            TigersStadiumImage stadiumImage = TigersStadiumImage.builder()
                    .path(stadiumImageDTO.getPath())
                    .imgName(stadiumImageDTO.getImgName())
                    .uuid(stadiumImageDTO.getUuid())
                    .tigersStadium(stadium)
                    .build();
            return stadiumImage;
        }).collect(Collectors.toList());
        entityMap.put("imgList", stadiumImageList);
        return entityMap;
    }

    // List
    default StadiumDTO entityToDTO(TigersStadium entity) {

        StadiumDTO stadiumDTO = StadiumDTO.builder()
                .sno(entity.getSno())
                .base(entity.getBase())
                .section(entity.getSection())
                .row(entity.getRow())
                .num(entity.getNum())
//                .email("member1@aa.com")
//                .nickname("ADMIN")
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();

        return stadiumDTO;
    }

    // Read
    default StadiumDTO entitiesToDTO(TigersStadium entity, List<TigersStadiumImage> stadiumImages) {
        StadiumDTO stadiumDTO = StadiumDTO.builder()
                .sno(entity.getSno())
                .base(entity.getBase())
                .section(entity.getSection())
                .row(entity.getRow())
                .num(entity.getNum())
                .content(entity.getContent())
//                .email("member1@aa.com")
//                .nickname("ADMIN")
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
