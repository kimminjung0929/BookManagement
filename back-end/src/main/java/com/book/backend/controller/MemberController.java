package com.book.backend.controller;

import com.book.backend.domain.Member;
import com.book.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping(value = "")
    public ResponseEntity<String> register(@RequestBody Member member) {
        String msg;

        Optional<Member> member_id = memberService.validateMember(member);

        if (member_id.isEmpty()) {
            memberService.saveMember(member);
            msg = "가입성공";
        } else {
            msg = "아이디가 중복 됩니다";
        }




        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Member>> getMembers() {
        List<Member> members = memberService.findAll();

        return new ResponseEntity<>(members, HttpStatus.OK);
    }
}
