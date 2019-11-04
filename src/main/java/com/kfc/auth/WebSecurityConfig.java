package com.kfc.auth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    public AuthenticationFailureHandler authenticationFailureHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/css/**", "/js/**", "/img/**").permitAll()
                .antMatchers("/member/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .anyRequest().permitAll();
        
        http.formLogin()
                .loginPage("/loginForm")        // default : /login
                .loginProcessingUrl("/j_spring_security_check")
                //.failureUrl("/login?error")        // default : /login?error
                //.defaultSuccessUrl("/")
                .failureHandler(authenticationFailureHandler)
                .usernameParameter("j_username")// default : j_username
                .passwordParameter("j_password")// default : j_password
                .permitAll();
        
        http.logout()
        		.logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll();
        
        // ssl을 사용하지 않으면 true로 사용
        http.csrf().disable();
    }
    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("user").password(passwordEncoder().encode("1234")).roles("USER")
//            .and()
//            .withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN");
//            // ROLE_ADMIN 에서 ROLE_는 자동으로 붙음
//    }
    
    @Autowired
    private DataSource dataSource;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select id, auth, enabled from member where id = ?")
            .rolePrefix("ROLE_")
            .authoritiesByUsernameQuery("select id, authority from member where id = ?")
            .passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}