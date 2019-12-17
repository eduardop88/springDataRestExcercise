package com.people.training.restpagandsort.controller;

import com.people.training.restpagandsort.model.Course;
import com.people.training.restpagandsort.services.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@RestController
@Validated
@RequestMapping(path="/courses")
public class CoursesController {

    public CoursesController(CourseService courseService) {
        this.courseService = courseService;
    }
    private CourseService courseService;

    @GetMapping
    Page<Course> getPagedCourses(Pageable pageable) {
        return courseService.findPagedCourses(pageable);
    }

    @GetMapping(path="/all")
    Iterable<Course> getAllCourses() {
        return courseService.findAllCourses();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Course newCourse(@RequestBody @NotBlank @NotEmpty Course newCourse){
        return courseService.saveCourse(newCourse);
    }

    @PutMapping
    Course updateCourse(@RequestBody Course newCourse, @PathVariable @NotBlank @Min(1) Long id){
        return  courseService.updateCourse(newCourse, id);
    }

    @GetMapping(path="/{id}")
    Course findById(@PathVariable @Min(1) Long id) {
        return courseService.findCourseById(id);
    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable @NotBlank @Min(1) Long id) {
        courseService.deleteCourseById(id);
    }

}
