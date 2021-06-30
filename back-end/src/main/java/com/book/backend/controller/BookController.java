package com.book.backend.controller;

import com.book.backend.domain.BookDTO;
import com.book.backend.domain.BookSearch;
import com.book.backend.domain.CategoryDTO;
import com.book.backend.service.BookService;
import com.book.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book")
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
    public ResponseEntity<List<CategoryDTO>> getCategoryList() {
        List<CategoryDTO> categoryDTOList = categoryService.getCategoryList();

        return new ResponseEntity<>(categoryDTOList, HttpStatus.OK);
    }

    // 도서 조회
    @GetMapping(value = "")
    public ResponseEntity<List<BookDTO>> getBookList(@RequestParam(value = "category", required = false, defaultValue = "all") String category) {
        BookSearch bookSearch = new BookSearch();
        bookSearch.setCategoryName(category);

        List<BookDTO> bookList = bookService.bookList(bookSearch);

        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }


    // 도서 등록 하기
    @PostMapping(value = "")
    public ResponseEntity<String> addBook(@RequestBody BookDTO bookDTO) {

        // 도서 등록하기

        String msg = bookService.addBook(bookDTO);


        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
