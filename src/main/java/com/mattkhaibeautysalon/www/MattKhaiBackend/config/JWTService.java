package com.mattkhaibeautysalon.www.MattKhaiBackend.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JWTService {
    public String extractUsername(String jwtToken) {
        return null;
    }

//    public Claims extractAllClaims(String token){
//        return Jwts
//                .parserBuilder()
//                .setSigningKey(getSignInKey())
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
}
