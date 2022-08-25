package com.bbgo.config.auth;

import com.bbgo.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetail implements UserDetails {
    private Member member;

    public PrincipalDetail(Member member) {
        this.member = member;
    }

    public Long getMno() {
        return member.getMno();
    }

    public String getName() {
        return member.getName();
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUsername();
    }

    // 계정 만료 확인(false: 만료)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정 잠김 확인(false: 잠김)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호 만료 확인(flase: 만료)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 활성화 확인(false: 비활성화)
    @Override
    public boolean isEnabled() {
        return true;
    }

    // 계정이 가진 권한 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(() -> {
            return "ROLE_USER";
        });

        return collectors;
    }
}
