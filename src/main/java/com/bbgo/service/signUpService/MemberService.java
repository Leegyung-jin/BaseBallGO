package com.bbgo.service.signUpService;

import com.bbgo.dto.common.MemberDTO;
import com.bbgo.entity.Member;

import java.util.HashMap;
import java.util.Map;

public interface MemberService {

    Long signUp(MemberDTO dto);

    // entity객체를 DTO객체로 변환
    default Map<String, Object> dtoToEntity(MemberDTO memberDTO) {
        Map<String, Object> entityMap = new HashMap<>();

        Member member = Member.builder()
                .mno(memberDTO.getMno())
                .email(memberDTO.getEmail())
                .nickname(memberDTO.getNickname())
                .password(memberDTO.getPassword())
                .build();
        entityMap.put("member", member);

        return entityMap;
    }
}
