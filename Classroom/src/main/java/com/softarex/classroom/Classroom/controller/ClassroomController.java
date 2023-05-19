package com.softarex.classroom.Classroom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassroomController {
    @GetMapping(value = "/login/")
    public String classroom() {
        return "classroom";
    }
}
