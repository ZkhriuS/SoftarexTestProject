package com.softarex.classroom.controller;

import com.softarex.classroom.model.Student;
import com.softarex.classroom.model.StudentRepository;
import com.softarex.classroom.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class ClassroomController {
    private final AppService service;

    public ClassroomController(AppService service) {
        this.service = service;
    }
    @MessageMapping(value = "/classroom")
    @SendTo("/classroom")
    public ResponseEntity<List<Student>> listClass() {
        List<Student> students = service.findAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @MessageMapping(value="/classroom/{id}")
    public ResponseEntity<Student> changeHandState(@Payload int id){
        Student student = service.getStudentById(id);
        student.setHandUp(!student.isHandUp());
        service.handUpDown(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
