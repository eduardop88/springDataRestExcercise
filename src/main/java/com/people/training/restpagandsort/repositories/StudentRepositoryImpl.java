package com.people.training.restpagandsort.repositories;

import com.people.training.restpagandsort.model.Student;

import javax.persistence.*;
import java.util.List;

public class StudentRepositoryImpl implements  StudentRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public String findStudentsOlderThan(Integer age) {
        Query findByAgeFunction =
                em.createNamedQuery("getStudentsOlderThan")
                        .setParameter(1, age);
        return (String)findByAgeFunction.getSingleResult();
    }
}
