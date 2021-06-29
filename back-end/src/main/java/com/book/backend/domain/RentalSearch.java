package com.book.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter @Setter
public class RentalSearch {

    private String bookName;

    @Enumerated(EnumType.STRING)
    private RentalStatus status; // 대여 상태 [RENTAL, RETURN]
}
