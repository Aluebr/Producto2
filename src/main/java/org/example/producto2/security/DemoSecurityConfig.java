package org.example.producto2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class DemoSecurityConfig {


@Bean
public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{

    http.authorizeHttpRequests(configurer ->
                    configurer
                            .requestMatchers("/productos").permitAll()
                            .requestMatchers("/").permitAll()
                            .requestMatchers("/menus/delete/{}").permitAll()
                            .requestMatchers("img/**").permitAll()
                            .requestMatchers("index.html").permitAll()
                            .requestMatchers(("css/**")).permitAll()
                            .requestMatchers(("js/**")).permitAll()
                            .requestMatchers("/menus/new").hasRole("MANAGER")
                            .requestMatchers("/systems/**").hasRole("ADMIN")
                            .anyRequest().authenticated()
                            )
            .formLogin(form ->
                    form
                            .loginPage("/login")
                            .loginProcessingUrl("/authenticateTheUser")
                            .permitAll()
            )
            .logout(logout -> logout.permitAll()
            );
            /*.exceptionHandling(configurer ->
                    configurer.accessDeniedPage("/access-denied"));*/
    return http.build();
       /* http
            .authorizeRequests(authorize -> authorize
                    .anyRequest().permitAll()
            )
            .csrf(csrf -> csrf.disable()); // Desactivar CSRF usando Customizer

    return http.build();*/
}

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "ADMIN", "MANAGER")
                .build();


        return new InMemoryUserDetailsManager(john,mary,susan);
    }

}
