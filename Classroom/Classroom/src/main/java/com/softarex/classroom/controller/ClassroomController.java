package com.softarex.classroom.controller;

import com.softarex.classroom.model.Student;
import com.softarex.classroom.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClassroomController {
    private final AppService appService;
    @Autowired
    public ClassroomController(AppService appService) {
        this.appService = appService;
    }
    @GetMapping(value = "/login/")
    public String classroom(Model model) {
        List<Student> students= appService.findAllStudents();
        model.addAttribute("students", students);
        return "classroom";
    }
}
