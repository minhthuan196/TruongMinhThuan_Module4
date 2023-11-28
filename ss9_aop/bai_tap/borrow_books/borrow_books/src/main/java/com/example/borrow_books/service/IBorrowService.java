package com.example.borrow_books.service;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.model.BorrowedCode;

import java.util.List;

public interface IBorrowService {
    void createBorrow(BorrowedCode borrowedCode);
    BorrowedCode checkBorrowedCode(int code);
    List<BorrowedCode> displayAllCode();
    void updateBorrowCode(BorrowedCode borrowedCode);
}
