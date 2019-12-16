package com.people.training.restpagandsort.services;

import com.people.training.restpagandsort.exceptions.EntityNotFound;
import com.people.training.restpagandsort.model.Course;
import com.people.training.restpagandsort.repositories.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Iterable<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course findCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new EntityNotFound(id));
    }

    @Override
    public Page<Course> findPagedCourses(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

    @Override
    public Course updateCourse(Course course, Long id) {
        courseRepository.findById(id).orElseThrow(() -> new EntityNotFound(id));
        course.setId(id);
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.findById(id).orElseThrow(() -> new EntityNotFound(id));
        courseRepository.deleteById(id);
    }
}
