package kr.co.patternbot.auth.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class AuthConfiguration extends WebSecurityConfigurerAdapter{
    //회원수정 후 세션 유지하기 위해

    @Bean @Override public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Override //보안이 걸렸는지 안 걸렸는지 볼라면 여기를 지웠다가 실행해보면 됨
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "*/**")
                .antMatchers("/");
    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers("/users/join").permitAll()
                .antMatchers("/users/login").permitAll()
                .antMatchers("/users/findAll").permitAll()
                .antMatchers("/users/count").permitAll()
                .antMatchers("/users/update").permitAll()
                .antMatchers("/users/delete").permitAll()
                .antMatchers("/users/deleteAll").permitAll()
                .antMatchers("/users/findAll/sort").permitAll()
                .antMatchers("/users/findAll/pageable").permitAll()
                .antMatchers("/users/findUsername").permitAll()
                .antMatchers("/users/logout").permitAll()
                .antMatchers("/users/findPw").permitAll()
                .antMatchers("/users/findById").permitAll()
                .antMatchers("/users/findByUsername").permitAll()
                .antMatchers("/users/token").permitAll()
                .anyRequest().authenticated();
        http.exceptionHandling().accessDeniedPage("/users/login");
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/users/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);

    }

}