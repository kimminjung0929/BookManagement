package com.book.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter @Setter
public class RentalResponse {
    private Long rentalId;
    private String memberId;
    private String bookName;
    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus;
    private LocalDate rentalDate;
    private LocalDate returnDate;

}
