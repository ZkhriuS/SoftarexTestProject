package com.softarex.classroom.Classroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class ClassroomApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ClassroomApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ClassroomApplication.class);
	}
}
