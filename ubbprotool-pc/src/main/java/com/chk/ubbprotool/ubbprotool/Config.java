package com.chk.ubbprotool.ubbprotool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class Config {
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.addAllowedHeader("Authorization");
        configuration.addExposedHeader("Authorization");
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.addAllowedOrigin("http://192.168.0.58:3000");
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}