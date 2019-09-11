package com.slinger.SpringBootCourseCatalog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       User.UserBuilder user = User.withDefaultPasswordEncoder();

       auth.inMemoryAuthentication()
               .withUser(user.username("admin").password("admin").roles("ADMIN"))
               .withUser(user.username("tessa").password("petey").roles("STUDENT"))
               .withUser(user.username("brent").password("petey").roles("INSTRUCTOR"));

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();

    }
}
