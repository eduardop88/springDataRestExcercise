package com.people.training.restpagandsort.services;

import com.people.training.restpagandsort.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student course);
    String findStudentOlderThan(Integer age);
}
