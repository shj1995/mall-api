package com.shj1995.mall.user.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;
import java.util.HashMap;

@Component
public class JwtTokenUtil implements InitializingBean {

    @Value("${jwt.expiration}")
    private Long expiration;

    private Clock clock;

    //    @Value("${jwt.secret}")
    private String secret = "36645e0b4c2645b2b09751653bdb094155a7e3298339442f97ef65097b277d8197b277d817d817d817d817d817d81";

    private static SecretKey SECRET_KEY;


    public String getUsernameForToken(String authToken) {
        return getClaims(authToken).getSubject();
    }

    private Claims getClaims(String authToken) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
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
                .setIssuedAt(nowDate)
                .setExpiration(new Date(nowDate.getTime() + this.expiration)) //过期时间
                .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
                .compact();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        SECRET_KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }
}
