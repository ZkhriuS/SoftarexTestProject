package com.softarex.classroom.controller;

import com.softarex.classroom.model.Student;
import com.softarex.classroom.model.StudentRepository;
import com.softarex.classroom.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/")
public class ClassroomController {
    private final StudentRepository repository;
    @Autowired
    public ClassroomController(StudentRepository repository) {
        this.repository = repository;
    }
    @GetMapping(value = "/classroom")
    public ResponseEntity<List<Student>> listClass() {
        List<Student> students = repository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping(value="/classroom/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id){
        return new ResponseEntity<>(repository.getReferenceById(id), HttpStatus.FOUND);
    }
}
