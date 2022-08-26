package com.bbgo.config;

import com.bbgo.config.auth.PrincipalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  // 특정 주소 접근 시 권한/인증 체크
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private PrincipalDetailService principalDetailService;
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/assets/**", "/font/**", "/stadiumImg/**");
    }

    @Autowired
    public SecurityConfig(PrincipalDetailService principalDetailService) {
        this.principalDetailService = principalDetailService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(principalDetailService).passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()           // csrf토큰 비활성화(csrf토큰이 있어야 접근 가능)
                .authorizeRequests()    // 인가 요청이 오면
                    .antMatchers(   // 해당 경로는
                           "/", "/main", "/signup", "/login", "/stadium", "/team", "/checkEmail"  
                            , "/landers", "/landers/"
                            , "/heroes", "/heroes/"
                            , "/twins", "/twins  /"
                    )
                    .permitAll()        // 접근을 허용
                    .anyRequest()       // 이외의 요청은
                    .authenticated()    //인증이 되야 들어갈 수 있다.
                .and()
                    .formLogin()
                    .loginPage("/login")     //로그인 페이지를 우리가 만든 페이지로 등록한다.
                    .loginProcessingUrl("/login")   //스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인해줌(서비스의 loadUserByName로 알아서)
                    .defaultSuccessUrl("/")        //정상일떄
//                    .successHandler(authenticationSuccessHandler)

            // 로그아웃
            .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");

        //중복 로그인
        http.sessionManagement()
            .maximumSessions(1)                 //세션 최대 허용 수
            .maxSessionsPreventsLogin(false);   // false이면 중복 로그인하면 이전 로그인이 풀린다.
    }
}
