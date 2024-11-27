package org.example.qlkv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    String secret = "QLKVKEYPRIVATEKHANHTNTECHBNVROXLVING2024JAVA"; // Secret key để giải mã

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
              .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/auth/**").permitAll()
                        .anyRequest().authenticated()
                );
      http.oauth2ResourceServer(
              oauth2 ->oauth2.jwt(jwtConfigurer ->
                              jwtConfigurer.decoder(jwtDecoder()))
      );
        return http.build();
    }

   @Bean
    JwtDecoder jwtDecoder() {
       SecretKeySpec keySpec = new SecretKeySpec(secret.getBytes(), "HS256");
       return NimbusJwtDecoder
               .withSecretKey(keySpec)
               .macAlgorithm(MacAlgorithm.HS256)
               .build();
   };

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
