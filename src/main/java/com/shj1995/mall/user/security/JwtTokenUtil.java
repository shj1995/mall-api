package com.shj1995.mall.user.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;
import java.util.HashMap;

@Component
public class JwtTokenUtil {

    @Value("${jwt.expiration}")
    private Long expiration;

    private Clock clock;
//    @Value("${jwt.secret}")
    private String secret = "secret";


    public String getUsernameForToken(String authToken) {
        return getClaims(authToken).getSubject();
    }

    private Claims getClaims(String authToken) {
        return Jwts.parser()
                    .setSigningKey(this.secret)
                    .parseClaimsJws(authToken)
                    .getBody();
    }

    public boolean validateToken(String authToken, SecurityUserDetails userDetails) {
        String username = this.getUsernameForToken(authToken);
        return StringUtils.equals(username, userDetails.getUsername()) && this.isTokenNotExpired(authToken);
    }

    private boolean isTokenNotExpired(String authToken) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.getClaims(authToken).getExpiration()));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return this.getClaims(authToken).getExpiration().after(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Date nowDate = new Date();
        return Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(userDetails.getUsername())
                .setIssuedAt(nowDate) //创建时间
                .setExpiration(new Date(nowDate.getTime() + this.expiration)) //过期时间
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
