package com.bbgo.service.stadiumService;

import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.common.PageResultDTO;
import com.bbgo.dto.team.StadiumDTO;
import com.bbgo.entity.Stadium;
import com.bbgo.entity.Team;

public interface LandersService {

    Long register(StadiumDTO dto);

    // PageRequestDTO-파라미터, PageResultDTO-리턴 타입으로 사용
    PageResultDTO<StadiumDTO, Stadium> getList(PageRequestDTO requestDTO);

    // entity객체를 DTO객체로 변환
    default Stadium dtoToEntity(StadiumDTO dto) {
        Team team = Team.builder().sName(dto.getSName()).build();

        Stadium entity = Stadium.builder()
                .sno(dto.getSno())
                .team(team)
                .base(dto.getBase())
                .section(dto.getSection())
                .row(dto.getRow())
                .num(dto.getNum())
                .build();
        return entity;
    }

    default StadiumDTO entityToDto(Stadium entity) {

        StadiumDTO dto = StadiumDTO.builder()
                .sno(entity.getSno())
                .sName(entity.getTeam().getSName())
                .base(entity.getBase())
                .section(entity.getSection())
                .row(entity.getRow())
                .num(entity.getNum())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }

}
