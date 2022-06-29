package com.shj1995.mall.user.security;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

    private final String tokenHeader = "Authorization";

    private final JwtUserDetailsServiceImpl userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String authToken = this.getAuthToken(httpServletRequest);

        if(StringUtils.isNotBlank(authToken) && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
                SecurityUserDetails userDetails = this.getUserDetails(authToken);
                if(userDetails != null && this.jwtTokenUtil.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            } catch (ExpiredJwtException e) {
                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"token 过期");
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private SecurityUserDetails getUserDetails(String authToken) {
        if (authToken == null) {
            return null;
        }
        String username = this.jwtTokenUtil.getUsernameForToken(authToken);
        if (StringUtils.isBlank(username)) {
            return null;
        }
        return (SecurityUserDetails) this.userDetailsService.loadUserByUsername(username);
    }

    private String getAuthToken(HttpServletRequest request) {
        final String requestHeader = request.getHeader(this.tokenHeader);

        if (requestHeader == null) {
            return null;
        }
        return requestHeader;
    }


}
