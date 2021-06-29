package com.book.backend.controller;

import com.book.backend.domain.BookDTO;
import com.book.backend.domain.MemberDTO;
import com.book.backend.domain.RentalRequest;
import com.book.backend.service.BookService;
import com.book.backend.service.MemberService;
import com.book.backend.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/rental")
public class RentalController {

    private final RentalService rentalService;
    private final BookService bookService;
    private final MemberService memberService;

    @Autowired
    public RentalController(RentalService rentalService, BookService bookService, MemberService memberService) {
        this.rentalService = rentalService;
        this.bookService = bookService;
        this.memberService = memberService;
    }

    /**
     * 회원, 도서 리스트 조회
     */
    @GetMapping(value = "/category")
    public ResponseEntity<HashMap<String, List<String>>> getCategory() {
        HashMap<String, List<String>> map = new HashMap<>();

        List<String> memberIdList = memberService.findId();
        List<String> bookNameList = bookService.findBookName();

        map.put("memberId", memberIdList);
        map.put("bookName", bookNameList);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    /**
     * 대여 내역 조회
     */
    @GetMapping(value = "")
    public void getRentalList() {
        rentalService.getRental();
    }

    /**
     * 대여 하기
     */
    @PostMapping(value = "")
    public ResponseEntity<String> addRental(@RequestBody RentalRequest rentalRequest) {
        System.out.println("rentalRequest = " + rentalRequest.getBookName());
        String msg = rentalService.rental(rentalRequest);


        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}
