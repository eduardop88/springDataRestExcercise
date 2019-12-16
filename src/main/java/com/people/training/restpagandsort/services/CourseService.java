package com.people.training.restpagandsort.services;

import com.people.training.restpagandsort.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface CourseService {
    Iterable<Course> findAllCourses();
    Course saveCourse(Course course);
    Course findCourseById(Long id);
    Page<Course> findPagedCourses(Pageable pageable);
    Course updateCourse(Course course, Long id);
    void deleteCourseById(Long id);
}
