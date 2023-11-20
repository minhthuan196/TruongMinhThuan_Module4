package com.codegym.demo_thymeleaf.service;


import com.codegym.demo_thymeleaf.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    boolean add(Student student);
    Student findById(int id);
}
