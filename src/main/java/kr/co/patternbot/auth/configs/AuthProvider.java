package kr.co.patternbot.auth.configs;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kr.co.patternbot.auth.service.AuthServiceImpl;
import kr.co.patternbot.users.domains.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Log //씨씨티비같은 역할, 방문자나 뭔 상황이 발생했을 때 로그를 찍어줌
@Component //스프링시큐리티가 알아야하기 때문에 컴포넌트를 걸었음
@RequiredArgsConstructor
public class AuthProvider implements AuthenticationProvider {

    private final AuthServiceImpl service;

    @Value("${security.jwt.token.security-key:secret-key}")
    private String securityKey;

    @Value("${security.jwt.token.expiration-length:3600000}")
    private long validityInMs = 3600000; // 1h

    @PostConstruct
    protected void init(){
        securityKey = Base64.getEncoder().encodeToString(securityKey.getBytes());
        log.info("securityKey: "+securityKey);
    }

    //roles는 사용자들 위치에 따라서 보기를 다르게 할 수 있는 코드
    public String createToken(String username, List<Role> roles){
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("auth", roles.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority()))
                .filter(Objects::nonNull).collect(Collectors.toList()));
        Date now = new Date();
        Date validity = new Date(now.getTime()+validityInMs);
        return Jwts.builder().setClaims(claims).setIssuedAt(now)
                .setExpiration(validity).signWith(SignatureAlgorithm.HS256, securityKey)
                .compact();
    }
    public Authentication getAuthentication(String token){
        UserDetails auth = service.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(auth.getAuthorities(), "", auth.getAuthorities());
    }
    public String getUsername(String token){
        return Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token).getBody().getSubject();
    }
    public String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer")){
            return bearerToken.substring(7);
        }
        return null;
    }
    public boolean validateToken(String token) throws Exception{
        try{
            Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token);
            return true;
        }catch(JwtException | IllegalArgumentException e){
            throw new Exception();
        }
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
