package com.example.borrow_books.controller;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.model.BorrowedCode;
import com.example.borrow_books.service.IBookService;
import com.example.borrow_books.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowService borrowService;

    @GetMapping
    public String showList(Model model) {
        List<Book> bookList = bookService.displayAllBook();
        model.addAttribute("bookList", bookList);
        return "/book/list";
    }

    @GetMapping("detail")
    public String detailBook(Model model, @RequestParam int id) {
        Book book = bookService.displayById(id);
        model.addAttribute("book", book);
        return "/book/detail";
    }

    @GetMapping("borrow")
    public String borrowBook(Model model, @RequestParam int id) {
        Book book = bookService.displayById(id);
        Random random = new Random();
        int min = 10000;
        int max = 99999;
        int borrowCode;
        do {
            borrowCode = random.nextInt((max - min) + 1) + min;
        } while (borrowService.checkBorrowedCode(borrowCode) != null);
        BorrowedCode borrowedCode;

        borrowedCode = new BorrowedCode(borrowCode, true, book);
        book.setQuantity(book.getQuantity() - 1);
        bookService.updateBook(book);
        model.addAttribute("borrowCode", borrowCode);
        return "/book/borrowBook";
    }

    @GetMapping("showCode")
    public String showCodeList(Model model) {
        List<BorrowedCode> borrowedCodeList = borrowService.displayAllCode();
        model.addAttribute("borrowedCodeList", borrowedCodeList);
        return "/borrowCode/list";
    }

    @GetMapping("returnBook")
    public String returnBook(RedirectAttributes redirectAttributes, @RequestParam int code) {
        BorrowedCode borrowedCode = borrowService.checkBorrowedCode(code);
        if (borrowedCode == null) {
            redirectAttributes.addFlashAttribute("mess1", "Code not correct");
            redirectAttributes.addFlashAttribute("code", code);
            return "redirect:/book";
        }
        borrowedCode.setStatus(false);
        borrowService.updateBorrowCode(borrowedCode);
        Book book = borrowedCode.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookService.updateBook(book);
        redirectAttributes.addFlashAttribute("mess", "return book success");
        return "redirect:/book";
    }


}