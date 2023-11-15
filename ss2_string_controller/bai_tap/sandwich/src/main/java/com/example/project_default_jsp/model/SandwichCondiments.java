package com.example.project_default_jsp.model;

public class SandwichCondiments {
    private int id;
    private String name;

    public SandwichCondiments(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public SandwichCondiments() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
