package com.softarex.classroom.service;

import com.softarex.classroom.model.Student;
import com.softarex.classroom.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService{
    StudentRepository repository;
    @Autowired
    public AppServiceImpl(StudentRepository repository){
        this.repository = repository;
    }
    @Override
    public List<Student> findAllStudents(){
        return repository.findAll();
    }
    @Override
    public void addStudent(Student student) {
        repository.save(student);
    }

    @Override
    public void handUpDown(Student student) {
        boolean handState = student.isHandUp();
        student.setHandUp(!handState);
        repository.save(student);
    }
}
