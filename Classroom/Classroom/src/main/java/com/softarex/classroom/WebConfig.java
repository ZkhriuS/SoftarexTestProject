package com.softarex.classroom;

import jakarta.servlet.http.HttpServlet;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*@Configuration
@ComponentScan
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    /*@Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setViewClass(JstlView.class);
        vr.setPrefix("/resources/static/*");
        vr.setSuffix(".html");
        return vr;
    }*/
    /*@Bean
    public DispatcherServlet dispatcherServlet() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setThreadContextInheritable(true);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        return dispatcherServlet;
    }
    @Bean
    public DispatcherServletRegistrationBean dispatcherServletRegistration() {
        DispatcherServletRegistrationBean registration = new DispatcherServletRegistrationBean(dispatcherServlet(), "/");
        registration.setLoadOnStartup(1);
        registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
        return registration;
    }*/
    /*@Bean
    public ServletRegistrationBean<HttpServlet> classroomServletRegistration(){
        ServletRegistrationBean<HttpServlet> registrationBean = new ServletRegistrationBean<>(dispatcherServlet(), "/login/");
        registrationBean.setLoadOnStartup(0);
        registrationBean.setName("classroom");
        return registrationBean;
    }*/
//}
