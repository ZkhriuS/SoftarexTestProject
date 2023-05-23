package com.softarex.classroom.controller;

import com.softarex.classroom.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    private final AppService appService;
    @Autowired
    public LoginController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping(value = "/")
    public String login() {
        return "login";
    }

}
