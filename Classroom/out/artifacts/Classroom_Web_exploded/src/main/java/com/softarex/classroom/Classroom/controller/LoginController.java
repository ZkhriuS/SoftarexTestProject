package com.softarex.classroom.Classroom.controller;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
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

@RestController
public class LoginController {
    @GetMapping(value = "/")
    public String login() {
        return "login";
    }
}
