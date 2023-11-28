package com.example.borrow_books.service;

import com.example.borrow_books.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> displayAllBook();

    Book displayById(int id);

    void updateBook(Book book);
}
