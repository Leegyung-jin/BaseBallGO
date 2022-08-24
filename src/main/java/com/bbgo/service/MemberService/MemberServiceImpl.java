package com.bbgo.service.MemberService;

import com.bbgo.dto.common.MemberDTO;
import com.bbgo.entity.Member;
import com.bbgo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public Long signUp(MemberDTO dto) {
        // 비밀번호 암호화 처리
        String pwd_before = dto.getPassword();
        String pwd_after = passwordEncoder.encode(pwd_before);
        dto.setPassword(pwd_after);

        Map<String, Object> entityMap = dtoToEntity(dto);
        Member member = (Member) entityMap.get("member");
        memberRepository.save(member);

        return member.getMno();
    }

    @Override
    public int checkEmail(String email) {
        int result = memberRepository.checkEmail(email);
        return result;
    }
}
