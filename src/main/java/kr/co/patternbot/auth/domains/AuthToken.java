package kr.co.patternbot.auth.domains;

import io.jsonwebtoken.*;
import lombok.extern.java.Log;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log //log찍는 이유는 토큰발급된걸 알아야하기 때문 감시시스템
public class AuthToken {
    private String token;
    private String key;

    public AuthToken(String key) {
        this.key = key;
        this.token = createToken();
    }
    //Exception은 개발자의 의도대로 만드는거임 누가 시스템에대해 비정상적으로 접근했을때 막는거임 그 코드가 아래.
    //트라이 영역을 벗어나면 토큰을 주지 않고 null값을 보내줌
    private String createToken() {
        try{
            Map<String, Object> headers = new HashMap<>();
            headers.put("typ","JWT");
            headers.put("alg","HS256");
            Map<String, Object> payload = new HashMap<>();
            payload.put("data","dummy");
            Date exp = new Date();
            exp.setTime(exp.getTime() + 1000 * 60L * 10L); // 10분
            return Jwts.builder()
                    .setHeader(headers)
                    .setClaims(payload)
                    .setSubject("user")
                    .setExpiration(exp)
                    .signWith(SignatureAlgorithm.HS256, key.getBytes())
                    .compact();
        }
        catch (SecurityException e){log.info("SecurityException JWT");}
        catch (MalformedJwtException e){log.info("MalformedJwtException JWT");}
        catch (ExpiredJwtException e){log.info("ExpiredJwtException JWT");}
        catch (UnsupportedJwtException e){log.info("UnsupportedJwtException JWT");}
        catch (IllegalAccessError e){log.info("IllegalAccessError JWT");}
        return null;
    }
}