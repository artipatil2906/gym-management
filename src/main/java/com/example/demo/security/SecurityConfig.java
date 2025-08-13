package com.example.demo.security;





import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/index","/about","/services","contact","/register","/trainers", "/css/**", "/js/**").permitAll() // allow home without login
                .anyRequest().authenticated()
            )
            .formLogin(login -> login
                .loginPage("/login") // your custom login page
                .defaultSuccessUrl("/home",true)
                .permitAll()
            )
            .logout(logout -> logout
            		.logoutSuccessUrl("/index")
            		.permitAll());

        return http.build();
    }
}
