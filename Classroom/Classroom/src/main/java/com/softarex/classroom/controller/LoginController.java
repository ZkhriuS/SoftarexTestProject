package com.softarex.classroom.controller;

import com.softarex.classroom.model.Student;
import com.softarex.classroom.model.StudentRepository;
import com.softarex.classroom.service.AppService;
import org.hibernate.result.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginController {
    private final AppService service;
    private SimpMessagingTemplate template;
    public LoginController(AppService service, SimpMessagingTemplate template) {
        this.service = service;
        this.template=template;
    }
    @MessageMapping(value = "/login")
    @SendTo("/classroom")
    public Student addStudent(@Payload Student data) {
        try {
            return service.addStudent(data);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
