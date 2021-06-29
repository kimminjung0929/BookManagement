package com.book.backend.service;

import com.book.backend.domain.*;
import com.book.backend.repository.BookRepository;
import com.book.backend.repository.MemberRepository;
import com.book.backend.repository.RentalItemRepository;
import com.book.backend.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
public class RentalService {

    private final RentalRepository rentalRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;
    private final RentalItemRepository rentalItemRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository, MemberRepository memberRepository, BookRepository bookRepository, RentalItemRepository rentalItemRepository) {
        this.rentalRepository = rentalRepository;
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
        this.rentalItemRepository = rentalItemRepository;
    }

    /**
     * 대여 하기
     */
    @Transactional
    public String rental(RentalRequest rentalRequest) {

        String msg;

        // 엔티티 조회
        Book book = bookRepository.findByName(rentalRequest.getBookName()).get(0);

        // 대여 시 도서 수량 -1
        msg = book.removeStock(1);

        if (!msg.equals("재고 없음")) {
            // 엔티티 조회
            Member member = memberRepository.findById(rentalRequest.getMemberId());
            // 대여 생성 & 저장
            Rental rental = new Rental();
            rental.setMember(member);
            rental.setStatus(RentalStatus.RENTAL);
            rental.setRentalDate(LocalDateTime.now());
            // persist 할 떄 id 생성 됨
            rentalRepository.save(rental);

            // 대여 아이템 생성
            RentalItem rentalItem = new RentalItem();
            rentalItem.setRental(rental);
            rentalItem.setBook(book);

            rentalItemRepository.save(rentalItem);

            msg = "대여 성공";
        }

        return msg;
    }

    /**
     * 반납하기
     */
    @Transactional
    public void returnBook(Long rentalId) {

        Rental rental = rentalRepository.findById(rentalId);
        Book book = rentalItemRepository.findByRental(rental).get(0).getBook();

        // 대여 상태, 반납 시간, 도서 재고 수량 + 1
        rental.setStatus(RentalStatus.RETURN);
        rental.setReturnDate(LocalDateTime.now());
        book.addStock(1);


    }


}
