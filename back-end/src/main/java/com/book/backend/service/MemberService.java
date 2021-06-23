package com.book.backend.service;

import com.book.backend.domain.Member;
import com.book.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String saveMember(Member member) {

        return memberRepository.save(member).getId();
    }

    public Optional<Member> validateMember(Member member) {
        Optional<Member> member_id = memberRepository.findById(member.getId());

        return  member_id;
    }

    public List<Member> findAll() {
        List<Member> results = memberRepository.findAll();

        return results;
    }

}
