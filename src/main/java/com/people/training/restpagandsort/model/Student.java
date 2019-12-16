package com.people.training.restpagandsort.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.people.training.restpagandsort.validators.ValidRut;
import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @NotEmpty
    private String firstname;
    @NonNull
    @NotEmpty
    private String lastname;
    private int age;
    @ValidRut
    private String rut;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "courseid", nullable = false)
    private Course course;
}
