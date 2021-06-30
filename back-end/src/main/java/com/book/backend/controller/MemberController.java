package com.book.backend.controller;

import com.book.backend.domain.MemberDTO;
import com.book.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping(value = "")
    public ResponseEntity<String> register(@RequestBody MemberDTO memberDto) {
        String msg = memberService.registerMember(memberDto);

        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<MemberDTO>> getMembers() {
        List<MemberDTO> memberList = memberService.findAll();

        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }
}
