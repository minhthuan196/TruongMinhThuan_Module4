package com.codegym.demo_spring_data_jpa_c07.service;


import com.codegym.demo_spring_data_jpa_c07.model.Student;
import com.codegym.demo_spring_data_jpa_c07.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> findAll(String searchName,Pageable pageable) {
        return studentRepository.search("%"+searchName+"%",pageable);
    }

    @Override
    public List<Student> search(String name) {
        return null;
    }
    @Override
    public void add(Student student) {
        // nếu id  chưa có trong db thì => create
        // nếu id có trong db => update
        studentRepository.save(student);
    }
    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }
}
