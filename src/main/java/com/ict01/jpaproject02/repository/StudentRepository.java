package com.ict01.jpaproject02.repository;

import com.ict01.jpaproject02.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
