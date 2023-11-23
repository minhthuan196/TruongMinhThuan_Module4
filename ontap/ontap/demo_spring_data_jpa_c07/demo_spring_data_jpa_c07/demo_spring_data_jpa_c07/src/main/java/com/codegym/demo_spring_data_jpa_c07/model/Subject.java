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
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "subject")
    private Set<StudentSubject> studentSubjects;

//    @ManyToMany(mappedBy = "subjectSet")
//    private Set<Student> studentSet;
}
