package org.example.qlkv.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.crypto.spec.SecretKeySpec;

@Controller
@EnableAutoConfiguration
public class SecurityConfig {
    private final  String[] PUBLIC_ENDPOINTS = {"/auth/api/user/login","/auth/api/user/create"};

    @Value("${jwt.signerKey}")
    private String SIGNER_KEY;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
       httpSecurity
               .csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(request ->
               request.requestMatchers(PUBLIC_ENDPOINTS).permitAll()
                       .requestMatchers(org.springframework.http.HttpMethod.OPTIONS, "/**").permitAll()
                       .anyRequest().authenticated()
       );


        httpSecurity.oauth2ResourceServer(oauthh2->
               oauthh2.jwt(jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder()))
       );

        return httpSecurity.build();
    }

    @Bean
    JwtDecoder jwtDecoder() {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SIGNER_KEY.getBytes(), "HS512");
        return  NimbusJwtDecoder
                .withSecretKey(secretKeySpec)
                .macAlgorithm(MacAlgorithm.HS512)
                .build();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:5173"); // Cho phép origin này
        config.addAllowedHeader("*"); // Cho phép tất cả các header
        config.addAllowedMethod("*"); // Cho phép tất cả các phương thức (GET, POST, PUT, DELETE,...)

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
