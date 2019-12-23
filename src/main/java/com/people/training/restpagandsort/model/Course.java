package com.people.training.restpagandsort.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;


    @OneToMany(cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY,
            mappedBy = "course")
    @JsonManagedReference
    private Set<Student> students;
}
