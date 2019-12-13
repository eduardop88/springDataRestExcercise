package com.people.training.restpagandsort.controller;

import com.people.training.restpagandsort.model.Course;
import com.people.training.restpagandsort.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/courses")
public class CoursesController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }


}
