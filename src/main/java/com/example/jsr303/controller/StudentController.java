package com.example.jsr303.controller;

import com.example.jsr303.common.R;
import com.example.jsr303.entity.Student;
import com.example.jsr303.service.IStudentService;
import com.example.jsr303.validate.group.AddGroup;
import com.example.jsr303.validate.group.UpdateGroup;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class StudentController {

    @Resource
    IStudentService studentService;


    @PostMapping
    public R add(@Validated(AddGroup.class) @RequestBody Student student){
        studentService.addStudent(student);
       return R.ok();
    }

    @PutMapping
    public R edit(@Validated(UpdateGroup.class)@RequestBody Student student)
    {
        studentService.editStudent(student);
        return R.ok();
    }

}
