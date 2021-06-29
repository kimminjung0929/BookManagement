package com.book.backend.controller;

import com.book.backend.domain.*;
import com.book.backend.service.BookService;
import com.book.backend.service.MemberService;
import com.book.backend.service.RentalItemService;
import com.book.backend.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/rental")
public class RentalController {

    private final RentalService rentalService;
    private final BookService bookService;
    private final MemberService memberService;
    private final RentalItemService rentalItemService;

    @Autowired
    public RentalController(RentalService rentalService, BookService bookService, MemberService memberService, RentalItemService rentalItemService) {
        this.rentalService = rentalService;
        this.bookService = bookService;
        this.memberService = memberService;
        this.rentalItemService = rentalItemService;
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
    public ResponseEntity<List<RentalResponse>> getRentalList(@RequestParam(value = "book", required = false, defaultValue = "") String bookName,
                              @RequestParam(value = "status", required = false, defaultValue = "") String rentalStatus) {
        
        RentalSearch rentalSearch = new RentalSearch();
        rentalSearch.setBookName(bookName);
        if (rentalStatus.equals("rental")) {
            rentalSearch.setStatus(RentalStatus.RENTAL);
        } else if (rentalStatus.equals("return")) {
            rentalSearch.setStatus(RentalStatus.RETURN);
        }
        
        List<RentalResponse> rentalResponseList = rentalItemService.getRentalList(rentalSearch);

        return new ResponseEntity<>(rentalResponseList, HttpStatus.OK);
    }

    /**
     * 대여 하기
     */
    @PostMapping(value = "")
    public ResponseEntity<String> addRental(@RequestBody RentalRequest rentalRequest) {
        System.out.println("rentalRequest = " + rentalRequest.getMemberId());
        String msg = rentalService.rental(rentalRequest);


        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    /**
     * 반납하기
     */
    @PutMapping(value = "/{id}")
    public void bookReturn(@PathVariable("id") Long rentalId) {

        rentalService.returnBook(rentalId);
    }

}
