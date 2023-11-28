package com.example.borrow_books.repository;

import com.example.borrow_books.model.BorrowedCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBorrowRepository extends JpaRepository<BorrowedCode, Integer> {
    @Query(value = "select * from borrowed_code where borrow_code = :code and status = 1", nativeQuery = true)
    BorrowedCode checkBorrowedCode(@Param("code") int code);

    @Query(value = "select * from  borrowed_code where status = 1", nativeQuery = true)
    List<BorrowedCode> findAllCode();
}
