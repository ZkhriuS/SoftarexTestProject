package com.softarex.classroom.Classroom.model;

import java.util.List;

public interface StudentRepository {
    List<Student> findAllStudents();
    void addStudent(Student student);
}
