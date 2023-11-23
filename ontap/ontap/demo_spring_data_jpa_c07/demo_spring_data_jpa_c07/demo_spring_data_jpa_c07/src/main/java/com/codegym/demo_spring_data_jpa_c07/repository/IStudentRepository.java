package com.codegym.demo_spring_data_jpa_c07.repository;




import com.codegym.demo_spring_data_jpa_c07.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IStudentRepository extends JpaRepository<Student,Integer> {

    // định nghĩa method search bằng method name
    List<Student> findStudentByNameContaining(String name);
    // đinh nghĩa câu query thuần
    @Query(value = "select * from student where name like :searchName",nativeQuery = true)
    Page<Student> search(@Param("searchName") String name, Pageable pageable);

}
