package com.softarex.classroom.Classroom.service;

import com.softarex.classroom.Classroom.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService{
    StudentRepository repository;
    @Autowired
    public AppServiceImpl(StudentRepository repository){
        this.repository = repository;
    }
}
