package com.dodoscompany.somedatademo.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user1 = User.builder()
                .username("DODOS")
                .password("{noop}pass111")
                .roles("EMPLOYEE")
                .build();

        UserDetails user2 = User.builder()
                .username("vlakas")
                .password("{noop}pass222")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails user3 = User.builder()
                .username("DODOS")
                .password("{noop}pass333")
                .roles("EMPLOYEE", "ADMIN","MANAGER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
}
