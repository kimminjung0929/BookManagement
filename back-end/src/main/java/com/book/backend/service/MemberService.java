package com.book.backend.service;

import com.book.backend.domain.Member;
import com.book.backend.domain.MemberDTO;
import com.book.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public String registerMember(MemberDTO memberDTO) {

        String msg;

        Optional<Member> member_id = validateMember(memberDTO);;

        if (member_id.isEmpty()) {
            Member member = new Member();
            member.setId(memberDTO.getId());
            member.setName(memberDTO.getName());
            member.setPhone(memberDTO.getPhone());

            memberRepository.save(member);

            msg = "가입성공";
        } else {
            msg = "아이디가 중복 됩니다";
        }

        return msg;
    }

    /**
     * ID 중복 체크
     */
    public Optional<Member> validateMember(MemberDTO memberDTO) {
        Optional<Member> member_id = memberRepository.findById(memberDTO.getId());

        return  member_id;
    }

    /**
     * 전체 회원 조회
     */
    public List<MemberDTO> findAll() {
        List<MemberDTO> memberDTOList = new ArrayList<>();

        List<Member> members = memberRepository.findAll();

        for (Member m : members) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setId(m.getId());
            memberDTO.setName(m.getName());
            memberDTO.setPhone(m.getPhone());

            memberDTOList.add(memberDTO);
        }

        return memberDTOList;
    }

}
