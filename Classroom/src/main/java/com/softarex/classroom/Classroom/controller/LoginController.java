package com.softarex.classroom.Classroom.controller;

import com.softarex.classroom.Classroom.WebConfig;
import com.softarex.classroom.Classroom.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Locale;

@Controller
public class LoginController {
    private AppService appService;
    @Autowired
    public LoginController(AppService appService){
        this.appService = appService;
    }
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
}
