package com.people.training.restpagandsort.repositories;

import com.people.training.restpagandsort.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface StudentRepository extends PagingAndSortingRepository<Student, Long>, StudentRepositoryCustom {
        //List<Student> findByLastname(@Param("name") String name);
    }

