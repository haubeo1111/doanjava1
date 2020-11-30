package com.example.demo.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{
	@Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable();
        // Các trang không yêu cầu login
    	// http.authorizeRequests().antMatchers("/", "/Login", "/logout").permitAll();
    	 // http.authorizeRequests().antMatchers("/LayOut/").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
    	//  http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
          // Trang chỉ dành cho ADMIN
        //  http.authorizeRequests().antMatchers("/admin/").access("hasRole('ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/DangKy/").permitAll()
        //.antMatchers("/").hasRole("nhanvien")
        //.antMatchers("/admin","/QLUser/**").hasRole("admin")
        // .antMatchers("/", "/home").access("hasRole('USER')")
          
        ;
       
      
		http.authorizeRequests()
		.antMatchers("/register").permitAll()
        .antMatchers("/").hasRole("MEMBER")
        .antMatchers("/admin").hasRole("ADMIN")
        //.anyRequest()
     	//.authenticated()
			.and()
			.formLogin()
			.loginPage("/Login/")
			 .usernameParameter("tendangnhap")
             .passwordParameter("password")
			
			.defaultSuccessUrl("/LayOut/").permitAll()
			.failureUrl("/Login/?error=true")
			.and()
			.exceptionHandling()
            .accessDeniedPage("/403");
            
            
		/*http
        .logout()
        .logoutUrl("/Logout")
        .logoutSuccessUrl("/Login/")
        .invalidateHttpSession(true)
        
        .deleteCookies()
        ;*/
       //.logoutSuccessUrl("/");
        
        
			
       /* http
            .authorizeRequests()
                .antMatchers("/DangKy/").permitAll()
                //.antMatchers("/").hasRole("nhanvien")
                .antMatchers("/admin","/QLUser/**").hasRole("admin")
               
               // .antMatchers("/", "/home").access("hasRole('USER')")
                //.antMatchers("/admin/**").hasRole("ADMIN")
                
                .and()
                
            .formLogin()
                .loginPage("/Login/")
                .usernameParameter("tendangnhap")
                .passwordParameter("password")
                .defaultSuccessUrl("/LayOut/")
                .failureUrl("/login?error");/*
                .and()
            .exceptionHandling()
                .accessDeniedPage("/403");
        //http
        //.logout()
        //.logoutUrl("/my/logout")
        //.logoutSuccessUrl("/my/index")
        //.logoutSuccessHandler(logoutSuccessHandler) 
        //.invalidateHttpSession(true)
        //.addLogoutHandler(logoutHandler)
        //.deleteCookies(cookieNamesToClear)
        //.and()*/
    }
}
