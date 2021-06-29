package com.book.backend.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RentalRequest {

    /**
     * 도서 대여 정보 ( 회원 아이디, 도서 이름 )
     */
    private String memberId;

    private String bookName;
}
