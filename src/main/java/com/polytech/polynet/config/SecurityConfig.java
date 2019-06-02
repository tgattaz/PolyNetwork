package com.polytech.polynet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //permission générale :
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/js/**").permitAll()
                .mvcMatchers("/login*").permitAll()
                .mvcMatchers("/register.html").permitAll()
                .mvcMatchers("/about","help").permitAll()
                .anyRequest().authenticated()
                //uniquement sous connection :
                .mvcMatchers("/admin/*").hasRole("ADMIN")

                .and()
                //page de connection :
                .formLogin()
                .loginPage("/login.html")
                .defaultSuccessUrl("/feed.html").permitAll()
                .loginProcessingUrl("/login")
                .and()
                //page de deconnection :
                .logout()
                .logoutUrl("/logout").permitAll()
                .logoutSuccessUrl("/")
                .and()
                .csrf().disable();

    }
}
