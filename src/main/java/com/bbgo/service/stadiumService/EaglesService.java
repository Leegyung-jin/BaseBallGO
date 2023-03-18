package com.bbgo.service.stadiumService;

import com.bbgo.config.auth.PrincipalDetail;
import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.common.PageResultDTO;
import com.bbgo.dto.team.StadiumDTO;
import com.bbgo.dto.team.StadiumImageDTO;
import com.bbgo.entity.stadium.EaglesStadium;
import com.bbgo.entity.stadium.EaglesStadiumImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface EaglesService {

    PageResultDTO<StadiumDTO, EaglesStadium> getList(PageRequestDTO requestDTO);
    Long register(StadiumDTO dto, PrincipalDetail principalDetail);

    StadiumDTO getStadium(Long sno);
    StadiumDTO getModify(long sno);

    // entity객체를 DTO객체로 변환
    default Map<String, Object> dtoToEntity(StadiumDTO stadiumDTO) {
        Map<String, Object> entityMap = new HashMap<>();

        String upperRow = stadiumDTO.getSRow().toUpperCase();
        EaglesStadium stadium = EaglesStadium.builder()
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

        if (imageDTOList != null && imageDTOList.size() > 0) {
            List<EaglesStadiumImage> stadiumImageList = imageDTOList.stream().map(stadiumImageDTO -> {
                EaglesStadiumImage stadiumImage = EaglesStadiumImage.builder()
                        .path(stadiumImageDTO.getPath())
                        .imgName(stadiumImageDTO.getImgName())
                        .uuid(stadiumImageDTO.getUuid())
                        .eaglesStadium(stadium)
                        .build();
                return stadiumImage;
            }).collect(Collectors.toList());
            entityMap.put("imgList", stadiumImageList);
        }
        return entityMap;
    }

    default StadiumDTO entityToDTO(EaglesStadium entity) {
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
    default StadiumDTO entitiesToDTO(EaglesStadium entity, List<EaglesStadiumImage> stadiumImages) {
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
