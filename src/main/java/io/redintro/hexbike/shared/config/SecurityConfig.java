package io.redintro.hexbike.shared.config;

import io.redintro.hexbike.adapter.in.web.filter.AuthenticationFilter;
import io.redintro.hexbike.adapter.in.web.filter.LoginFilter;
import io.redintro.hexbike.service.HexBikeUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final HexBikeUserDetailsService userDetailsService;

    public SecurityConfig(HexBikeUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/callbacks")
                .permitAll()
                .antMatchers(
                        "/api-docs/**",
                        "/swagger-ui.html",
                        "/swagger-ui/**",
                        "/swagger-resources",
                        "/swagger-resources/**")
                .permitAll()
                .antMatchers("/actuator/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilterBefore(new LoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Collections.singletonList("*"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setAllowCredentials(true);
        config.applyPermitDefaultValues();

        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
