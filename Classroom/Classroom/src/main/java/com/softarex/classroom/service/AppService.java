package com.softarex.classroom.service;

import com.softarex.classroom.model.Student;

import java.util.List;

public interface AppService {
    List<Student> findAllStudents();
    void addStudent(Student student);
    void handUpDown(Student student);
}
