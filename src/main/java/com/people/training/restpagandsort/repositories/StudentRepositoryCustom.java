package com.people.training.restpagandsort.repositories;

import com.people.training.restpagandsort.model.Student;

import java.util.List;

public interface StudentRepositoryCustom {

    String findStudentsOlderThan(Integer age);
}
