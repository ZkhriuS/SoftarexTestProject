package com.softarex.classroom.Classroom.model;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{
    private List<Student> repository;
    public StudentRepositoryImpl(List<Student> repository){
        if(repository==null)
            this.repository = new ArrayList<>();
        else
            this.repository = repository;
    }
    @Override
    public List<Student> findAllStudents() {
        return repository;
    }

    @Override
    public void addStudent(Student student) {
        repository.add(student);
    }
}
