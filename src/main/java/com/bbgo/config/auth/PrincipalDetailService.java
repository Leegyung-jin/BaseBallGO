package com.bbgo.config.auth;

import com.bbgo.entity.Member;
import com.bbgo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService {

    private MemberRepository memberRepository;

    @Autowired
    public PrincipalDetailService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Security가 로그인 요청을 가로챌 때 가져오는 변수: username, password
    // password는 알아서 처리하고, username이 DB에 존재하는지 확인한다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member principal = (Member) memberRepository.findByUsername(username)
                .orElseThrow(() ->{
                    return new UsernameNotFoundException("해당 이메일을 찾을수 없습니다.");
                });


        return new PrincipalDetail(principal); //시큐리티의 세션에 유저 정보가 저장
    }
}
