package com.people.training.restpagandsort.services;

import com.people.training.restpagandsort.model.Student;
import com.people.training.restpagandsort.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSeviceImpl implements StudentService{

    private StudentRepository studentRepository;

    public StudentSeviceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public String findStudentOlderThan(Integer age) {
        return studentRepository.findStudentsOlderThan(age);
    }
}
