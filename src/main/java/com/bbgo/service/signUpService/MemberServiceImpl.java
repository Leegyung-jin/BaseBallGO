package com.bbgo.service.signUpService;

import com.bbgo.dto.common.MemberDTO;
import com.bbgo.entity.Member;
import com.bbgo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Long signUp(MemberDTO dto) {
        Map<String, Object> entityMap = dtoToEntity(dto);
        Member member = (Member) entityMap.get("member");
        memberRepository.save(member);

        return member.getMno();
    }
}
