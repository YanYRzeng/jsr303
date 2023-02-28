package com.example.jsr303.service.impl;

import com.example.jsr303.entity.Student;
import com.example.jsr303.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements IStudentService {
    List<Student> students=new ArrayList<>();
    @Override
    public void addStudent(Student student) {
        students.add(student);
        students.forEach(item->{
            log.info(item.toString());
        });
    }

    @Override
    public void editStudent(Student student) {
       log.info(student.toString());
    }
}
