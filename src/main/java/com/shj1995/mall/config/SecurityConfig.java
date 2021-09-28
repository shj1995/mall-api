package com.shj1995.mall.config;

import com.shj1995.mall.user.security.JwtAuthenticationEntryPoint;
import com.shj1995.mall.user.security.JwtAuthorizationTokenFilter;
import com.shj1995.mall.user.security.JwtUserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtUserDetailsServiceImpl userService;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAuthorizationTokenFilter jwtAuthorizationTokenFilter;

    @Bean("passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(this.passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/doc.html").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/swagger-resources").permitAll()
                .antMatchers("/sactuator/**").permitAll()
                .antMatchers("/swagger-resources/configuration/ui").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/api/tk/systemInfo/current").permitAll()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/toolkit/file/**").permitAll()
                .antMatchers("/product/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login/auth").permitAll()//请求时未登录跳转接口
                .failureUrl("/login/fail")//用户密码错误跳转接口
                .defaultSuccessUrl("/login/success",true)//登录成功跳转接口
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtAuthorizationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }


}
