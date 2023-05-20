package com.softarex.classroom.Classroom.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
    private List<Student> repository;
    @Autowired
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
