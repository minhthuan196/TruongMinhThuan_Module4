package com.example.borrow_books.service;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> displayAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book displayById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void updateBook(Book book) {
        if (bookRepository.existsById(book.getIdBook())) {
            bookRepository.save(book);
        }
    }
}
