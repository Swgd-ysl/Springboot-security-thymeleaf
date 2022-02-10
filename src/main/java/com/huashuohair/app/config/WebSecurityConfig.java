package com.huashuohair.app.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huashuohair.app.common.Msg;
import com.huashuohair.app.exception.HuaShuoAccessDeniedHandler;
import com.huashuohair.app.filter.HuaShuoAuthenticationFilter;
import com.huashuohair.app.service.MyUserDetailsService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Autowired
	private HuaShuoAccessDeniedHandler  huaShuoAccessDeniedHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring()
	    .antMatchers("/js/**", "/css/**","/images/**")
	    .antMatchers("/swagger-ui.html")
	    .antMatchers("/swagger-ui/**")
        .antMatchers("/v2/**")
        .antMatchers("/v3/**")
        .antMatchers("/webjars/**")
        .antMatchers("/swagger-resources/**");
	}
	
	@Override
	@Autowired
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        	.antMatchers("/swagger-ui.html").permitAll()
            .antMatchers("/User/**").hasRole("AdminManager")
            .antMatchers("/Permission/**").hasRole("CommonUser")
            .anyRequest().authenticated()  // 需要身份认证
            .and()   //表示一个配置的结束
            .formLogin()
            .loginPage("/Login")
            .loginProcessingUrl("/doLogin")
            .defaultSuccessUrl("/Index")
            .permitAll()  //开启SpringSecurity内置的表单登录，会提供一个/login接口
            .and()
            .logout()
            .deleteCookies()
            .clearAuthentication(true)//清除权限相关
            .invalidateHttpSession(true)//清除session
            .permitAll()  //开启SpringSecurity内置的退出登录，会为我们提供一个/logout接口
            .and()
            .exceptionHandling()
	        //.authenticationEntryPoint(huaShuoAuthenticationEntryPoint)
	        .accessDeniedHandler(huaShuoAccessDeniedHandler)
            .and()
            .csrf().disable();    //关闭csrf跨站伪造请求;
        //通过json传递用户名和密码
        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
	
	//身份验证，登录成功/失败，返回json
	@Bean
	HuaShuoAuthenticationFilter customAuthenticationFilter() throws Exception {
		HuaShuoAuthenticationFilter filter = new HuaShuoAuthenticationFilter();
	    filter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
	        @Override
	        public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
	            resp.setContentType("application/json;charset=utf-8");
	            PrintWriter out = resp.getWriter();
	            Msg msg = Msg.success();
	            msg.add("data", "登录成功");
	            out.write(new ObjectMapper().writeValueAsString(msg));
	            out.flush();
	            out.close();
	        }
	    });
	    filter.setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
	        @Override
	        public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException, ServletException {
	            resp.setContentType("application/json;charset=utf-8");
	            PrintWriter out = resp.getWriter();
	            Msg msg = Msg.fail();
	            if (exception instanceof LockedException) {
	            	msg.add("data", "登陆失败：账户被锁定，请联系管理员!");
	            } else if (exception instanceof CredentialsExpiredException) {
	            	msg.add("data", "登陆失败：密码过期，请联系管理员!");
	            } else if (exception instanceof AccountExpiredException) {
	            	msg.add("data", "登陆失败：账户过期，请联系管理员!");
	            } else if (exception instanceof DisabledException) {
	            	msg.add("data", "登陆失败：账户被禁用，请联系管理员!");
	            } else if (exception instanceof BadCredentialsException) {
	            	msg.add("data", "登陆失败：用户名或者密码输入错误，请重新输入!");
	            }
	            out.write(new ObjectMapper().writeValueAsString(msg));
	            out.flush();
	            out.close();
	        }
	    });
	    filter.setAuthenticationManager(authenticationManagerBean());
	    return filter;
	}
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}