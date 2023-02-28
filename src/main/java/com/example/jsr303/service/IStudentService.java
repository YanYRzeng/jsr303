package com.example.jsr303.service;

import com.example.jsr303.entity.Student;

public interface IStudentService {
    void addStudent(Student student);

    void editStudent(Student student);
}
