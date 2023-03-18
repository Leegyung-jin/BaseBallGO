package com.bbgo.service.stadiumService;

import com.bbgo.config.auth.PrincipalDetail;
import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.common.PageResultDTO;
import com.bbgo.dto.team.StadiumDTO;
import com.bbgo.dto.team.StadiumImageDTO;
import com.bbgo.entity.stadium.DinosStadium;
import com.bbgo.entity.stadium.DinosStadiumImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface DinosService {

    // List
    // PageRequestDTO-파라미터, PageResultDTO-리턴 타입으로 사용
    PageResultDTO<StadiumDTO, DinosStadium> getList(PageRequestDTO requestDTO);

    // Register
    Long register(StadiumDTO dto, PrincipalDetail principalDetail);

    StadiumDTO getStadium(Long sno);
    StadiumDTO getModify(long sno);

    // entity객체를 DTO객체로 변환
    default Map<String, Object> dtoToEntity(StadiumDTO stadiumDTO) {
        Map<String, Object> entityMap = new HashMap<>();

        String upperRow = stadiumDTO.getSRow().toUpperCase();
        DinosStadium stadium = DinosStadium.builder()
                .sno(stadiumDTO.getSno())
                .base(stadiumDTO.getBase())
                .section(stadiumDTO.getSection())
                .sRow(upperRow)
                .num(stadiumDTO.getNum())
                .content(stadiumDTO.getContent())
                .username(stadiumDTO.getUsername())
                .name(stadiumDTO.getName())
                .mno(stadiumDTO.getMno())
                .build();
        entityMap.put("stadium", stadium);
        List<StadiumImageDTO> imageDTOList = stadiumDTO.getImageDTOList();

        // StadiumImageDTO 처리
        if (imageDTOList != null && imageDTOList.size() > 0) {
            List<DinosStadiumImage> stadiumImageList = imageDTOList.stream().map(stadiumImageDTO -> {
                DinosStadiumImage stadiumImage = DinosStadiumImage.builder()
                        .path(stadiumImageDTO.getPath())
                        .imgName(stadiumImageDTO.getImgName())
                        .uuid(stadiumImageDTO.getUuid())
                        .dinosStadium(stadium)
                        .build();
                return stadiumImage;
            }).collect(Collectors.toList());
            entityMap.put("imgList", stadiumImageList);
        }
        return entityMap;
    }

    // List
    default StadiumDTO entityToDTO(DinosStadium entity) {

        StadiumDTO stadiumDTO = StadiumDTO.builder()
                .sno(entity.getSno())
                .base(entity.getBase())
                .section(entity.getSection())
                .sRow(entity.getSRow())
                .num(entity.getNum())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .username(entity.getUsername())
                .name(entity.getName())
                .mno(entity.getMno())
                .build();

        return stadiumDTO;
    }

    // Read
    default StadiumDTO entitiesToDTO(DinosStadium entity, List<DinosStadiumImage> stadiumImages) {
        StadiumDTO stadiumDTO = StadiumDTO.builder()
                .sno(entity.getSno())
                .base(entity.getBase())
                .section(entity.getSection())
                .sRow(entity.getSRow())
                .num(entity.getNum())
                .content(entity.getContent())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .username(entity.getUsername())
                .name(entity.getName())
                .mno(entity.getMno())
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

    void delete(Long sno);
}
