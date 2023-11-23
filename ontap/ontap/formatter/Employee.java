package com.example.demo_spring_jpa_c05.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Employee {

    private int id;
    private String name;

    private LocalDate birthday;

    public Employee() {
    }

    public LocalDate getBirthday() {
        return birthday;
    }

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
