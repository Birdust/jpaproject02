package com.ict01.jpaproject02.service;

import com.ict01.jpaproject02.ResourceNotFoundException;
import com.ict01.jpaproject02.model.Student;

import java.util.List;

public interface StudentService {
  public List<Student> lists();

  public void saveStudent(Student student);

  public Student getStudent(int id) throws ResourceNotFoundException;

  public void deleteStudent(int id) throws ResourceNotFoundException;
}
