package com.codegym.demo_spring_data_jpa_c07.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int gender;

    @OneToOne
    // tên khoá ngoại
    @JoinColumn(name = "username")
    private Jame jame;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private StudentClass studentClass;

    @OneToMany(mappedBy = "student")
    private Set<StudentSubject> studentSubjects;

//    @ManyToMany
//    @JoinTable(name = "student_subject",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "subject_id")
//            )
//
//    private Set<Subject> subjectSet;


}
