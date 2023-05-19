package com.softarex.classroom.Classroom;

import com.softarex.classroom.Classroom.model.Student;
import com.softarex.classroom.Classroom.model.StudentRepository;
import com.softarex.classroom.Classroom.model.StudentRepositoryImpl;
import com.softarex.classroom.Classroom.service.AppService;
import com.softarex.classroom.Classroom.service.AppServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages =
        {"com.softarex.classroom.Classroom"})
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/WEB-INF/views/");
        vr.setSuffix(".jsp");
        return vr;
    }

    @Bean
    public AppService appService(StudentRepository repository) {
        return new AppServiceImpl(repository);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable("classroom");
    }
}
