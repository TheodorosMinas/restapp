package com.dodoscompany.somedatademo.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails user1 = User.builder()
//                .username("theo")
//                .password("{noop}pass111")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails user2 = User.builder()
//                .username("vlakas")
//                .password("{noop}pass222")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        UserDetails user3 = User.builder()
//                .username("zwon")
//                .password("{noop}pass333")
//                .roles("EMPLOYEE", "ADMIN","MANAGER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2, user3);
//    }/dodos

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((configurer) ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/emplApi/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/processForm").permitAll()
                        .requestMatchers(HttpMethod.GET, "/dodos/employees").permitAll()
                        .requestMatchers(HttpMethod.POST, "/dodos/deleteEmployee").permitAll()
                        .requestMatchers(HttpMethod.POST, "/dodos/addingEmployee").permitAll()
                        .requestMatchers(HttpMethod.POST, "/dodos/updateForm").permitAll()

                        .requestMatchers(HttpMethod.GET, "/dodos/addEmployee").permitAll()
                        .requestMatchers(HttpMethod.GET, "/hello").permitAll()
                        .requestMatchers(HttpMethod.POST, "/customerWelcome").permitAll()
                        .requestMatchers(HttpMethod.GET, "/customerLogin").permitAll()
                        .requestMatchers(HttpMethod.GET, "/emplApi/employee/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "e/mplApi/employee").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/emplApi/employee").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/emplApi/employee/**").hasRole("ADMIN"));
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager= new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password, enabled from users where username=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username, authority from authorities where username=?");
        return jdbcUserDetailsManager;
    }


}
