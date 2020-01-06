package com.people.training.restpagandsort.controller;

import com.people.training.restpagandsort.model.Student;
import com.people.training.restpagandsort.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping(path="/students")
public class StudentsController {

    private StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student newStudent(@Valid @RequestBody Student newStudent){
        return studentService.saveStudent(newStudent);
    }

    @GetMapping(path="/older/{age}")
    public String studentsOlderThan(@PathVariable Integer age){
        return studentService.findStudentOlderThan(age);
    }


}
