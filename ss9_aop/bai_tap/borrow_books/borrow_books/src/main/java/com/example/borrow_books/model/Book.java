package com.example.borrow_books.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBook;
    private String nameBook;
    private String author;
    private String describes;
    private int quantity;
    @OneToMany(mappedBy = "book")
    private Set<BorrowedCode> borrowedCodeSet;

}
