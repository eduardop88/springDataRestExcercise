package com.people.training.restpagandsort.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.people.training.restpagandsort.validators.ValidRut;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.MERGE)
    @JoinColumn(name = "courseid", nullable = false)
    @JsonBackReference
    private Course course;
}
