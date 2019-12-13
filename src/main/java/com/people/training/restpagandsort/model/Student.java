package com.people.training.restpagandsort.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    @NonNull
    @NotEmpty
    private String firstname;
    @Getter
    @Setter
    @NonNull
    @NotEmpty
    private String lastname;
    @Getter
    @Setter
    @NonNull
    @NotEmpty
    private int age;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "courseid", nullable = false)
    @Setter
    private Course course;
}
