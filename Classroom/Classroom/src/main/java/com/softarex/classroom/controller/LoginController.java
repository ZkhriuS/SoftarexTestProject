package com.softarex.classroom.controller;

import com.softarex.classroom.model.Student;
import com.softarex.classroom.model.StudentRepository;
import com.softarex.classroom.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/")
public class LoginController {
    private final StudentRepository repository;
    @Autowired
    public LoginController(StudentRepository repository) {
        this.repository = repository;
    }
    @PostMapping(value = "/login")
    public ResponseEntity<Student> addStudent(@RequestBody Student data) {
        try {
            Student student = repository.save(data);
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/login")
    public ResponseEntity<List<Student>> findAllStudents() {
        List<Student> students =repository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
