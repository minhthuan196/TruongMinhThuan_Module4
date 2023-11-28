package com.example.borrow_books.service;

import com.example.borrow_books.model.BorrowedCode;
import com.example.borrow_books.repository.IBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private IBorrowRepository borrowRepository;

    @Override
    public void createBorrow(BorrowedCode borrowedCode) {
        borrowRepository.save(borrowedCode);
    }

    @Override
    public BorrowedCode checkBorrowedCode(int code) {
        return borrowRepository.checkBorrowedCode(code);
    }

    @Override
    public List<BorrowedCode> displayAllCode() {
        return borrowRepository.findAllCode();
    }

    @Override
    public void updateBorrowCode(BorrowedCode borrowedCode) {
        if (borrowRepository.existsById(borrowedCode.getIdBorrow())) {
            borrowRepository.save(borrowedCode);
        }
    }


}
