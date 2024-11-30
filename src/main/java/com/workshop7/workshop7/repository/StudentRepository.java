package com.workshop7.workshop7.repository;

import com.workshop7.workshop7.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}
