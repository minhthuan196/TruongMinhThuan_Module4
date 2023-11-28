package com.example.borrow_books.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowedCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBorrow;
    private int borrowCode;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;

    public BorrowedCode(int borrowCode, boolean status, Book book) {
        this.borrowCode = borrowCode;
        this.status = status;
        this.book = book;
    }
}
