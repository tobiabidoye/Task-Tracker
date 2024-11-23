package com.example.TaskTrackerApp.Security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
@Component
public class JwtTokenProvider {
    private final String SECRET_KEY = System.getenv("JWT_SECRET");
    private final long EXPIRATION_TIME = 86400000;

    //Generate token step 1
    public String GenerateToken(String username, String Role){ 
        return Jwts.builder()
               .subject(username)
                .claim("role", Role)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8)))
                .compact();

    }

    //validate token step 2
    @SuppressWarnings("deprecation")
    public Claims validateToken(String token){ 
           return Jwts.parser()
                    .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
    }
}
