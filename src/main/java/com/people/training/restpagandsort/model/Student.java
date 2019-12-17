package com.people.training.restpagandsort.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.people.training.restpagandsort.validators.ValidRut;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String firstname;

    @NotEmpty
    private String lastname;

    private int age;

    @ValidRut
    private String rut;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.MERGE)
    @JoinColumn(name = "courseid", nullable = false)
    private Course course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
