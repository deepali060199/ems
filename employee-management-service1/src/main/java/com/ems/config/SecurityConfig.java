package com.ems.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {



    @Bean
    public UserDetailsService userDetails(PasswordEncoder encoder){
        UserDetails admin= User.withUsername("Deepak")

                .password(encoder.encode("Deepak@99"))
                .roles("ADMIN")
                .build();
        UserDetails user1= User.withUsername("User1")
                .password(encoder.encode("Pwd1"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin,user1);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return  http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/v1/employees/id/**").permitAll()
//                .and()
                .authorizeHttpRequests()
                .requestMatchers("/v1/employees/**").authenticated()
                .and().formLogin(form -> form
                        .loginPage("/login")
                        .permitAll())
                .build();














    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
