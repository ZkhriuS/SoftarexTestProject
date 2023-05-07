package com.softarex.classroom.Classroom.dao;

public interface ObjectDAO<T> {
    T read();
    void create(T obj);
    void delete(T obj);
    void update(T obj);
}
