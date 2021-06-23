package com.book.backend.controller;

import com.book.backend.domain.Book;
import com.book.backend.domain.Category;
import com.book.backend.domain.RequestAddBook;
import com.book.backend.service.BookService;
import com.book.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;
    private final CategoryService categoryService;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    // 도서 분류 목록 가져오기
    @GetMapping(value = "/category")
    public ResponseEntity<List<String>> getCategoryList() {
        List<String> category_name = categoryService.getCategoryList();

        return new ResponseEntity<>(category_name, HttpStatus.OK);
    }

    // 도서 조회

    // 도서 등록 하기
    @PostMapping(value = "")
    public ResponseEntity<String> addBook(@RequestBody RequestAddBook requestAddBook) {

        // 도서 등록하기

        String msg = bookService.addBook(requestAddBook);


        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
