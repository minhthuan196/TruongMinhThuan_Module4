package com.codegym.demo_spring_data_jpa_c07.service;




import com.codegym.demo_spring_data_jpa_c07.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Page<Student> findAll(String seachName,Pageable pageable);
    List<Student> search(String name);
    void add(Student student);
    Student findById(int id);
}
