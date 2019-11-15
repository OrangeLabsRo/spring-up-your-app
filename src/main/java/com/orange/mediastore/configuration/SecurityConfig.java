package com.orange.mediastore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.orange.mediastore.configuration.MediaConstants.API_V1;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String API_ENDPOINT =  API_V1 + "/**";
    private static final String[] ENDPOINTS_NOAUTH = {
            "/register",
            "/ui/login",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/configuration/ui",
            "/swagger-resources/configuration/security"};

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(API_ENDPOINT)
                .authenticated();

        http.authorizeRequests()
                .antMatchers(ENDPOINTS_NOAUTH)
                .permitAll();

        http.httpBasic();
        http.csrf().disable();

    }
}
