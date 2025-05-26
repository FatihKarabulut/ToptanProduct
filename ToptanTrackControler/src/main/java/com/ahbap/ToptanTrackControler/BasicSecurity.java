package com.ahbap.ToptanTrackControler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class BasicSecurity {

    @Bean
    public SecurityFilterChain defaultSecurity(HttpSecurity http) throws Exception{

        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(a ->
                                        a.requestMatchers("product/delete-by-name").hasRole("ADMIN")
                                       .requestMatchers("product/delete-all").hasRole("ADMIN")
                                                .requestMatchers("product/findAll").hasRole("ADMIN")

                                .anyRequest().permitAll()
                ).formLogin(withDefaults()
                ).logout(withDefaults())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService()
    {
        var user = User.withUsername("ahbap")
                .password(passwordEncode().encode("user123"))
                .roles("USER")
                .build();

        UserDetails Admin = User.withUsername("admin")
                .password(passwordEncode().encode("admin123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user,Admin);
    }

    @Bean
    public PasswordEncoder passwordEncode()
    {
        return new BCryptPasswordEncoder();
    }

}
