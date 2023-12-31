package com.example.borrow_books.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    static int count = 0;

    @After("execution(* com.example.borrow_books.controller.BookController.*(..))")
    public void countUser() {
        count++;
        System.out.println("Number of user visited " + count);
    }
}
