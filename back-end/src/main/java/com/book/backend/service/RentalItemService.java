package com.book.backend.service;

import com.book.backend.domain.Book;
import com.book.backend.domain.RentalItem;
import com.book.backend.domain.RentalResponse;
import com.book.backend.domain.RentalSearch;
import com.book.backend.repository.BookRepository;
import com.book.backend.repository.RentalItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class RentalItemService {
    
    private final RentalItemRepository rentalItemRepository;
    private final BookRepository bookRepository;

    @Autowired
    public RentalItemService(RentalItemRepository rentalItemRepository, BookRepository bookRepository) {
        this.rentalItemRepository = rentalItemRepository;
        this.bookRepository = bookRepository;
    }

    /**
     * 대여 내역 조회
     */
    public List<RentalResponse> getRentalList(RentalSearch rentalSearch) {
        
        Book book = null;
        
        if (!rentalSearch.getBookName().isEmpty()) {
            book = bookRepository.findByName(rentalSearch.getBookName()).get(0);
        }

        List<RentalItem> rentalItemList = rentalItemRepository.findAll(book);

        List<RentalResponse> rentalResponseList = new ArrayList<>();

        if (rentalSearch.getStatus() == null) {  // 상태 검색 x
            for (RentalItem i : rentalItemList) {
                RentalResponse rentalResponse = new RentalResponse();
                rentalResponse.setRentalId(i.getRental().getId());
                rentalResponse.setMemberId(i.getRental().getMember().getId());
                rentalResponse.setRentalStatus(i.getRental().getStatus());
                rentalResponse.setBookName(i.getBook().getName());
                rentalResponse.setRentalDate(i.getRental().getRentalDate());
                rentalResponse.setReturnDate(i.getRental().getReturnDate());

                rentalResponseList.add(rentalResponse);
            }
        } else { // 상태 검색 o
            for (RentalItem i : rentalItemList) {
                if (rentalSearch.getStatus() != i.getRental().getStatus()) {
                    continue;
                }
                RentalResponse rentalResponse = new RentalResponse();
                rentalResponse.setRentalId(i.getRental().getId());
                rentalResponse.setMemberId(i.getRental().getMember().getId());
                rentalResponse.setRentalStatus(i.getRental().getStatus());
                rentalResponse.setBookName(i.getBook().getName());
                rentalResponse.setRentalDate(i.getRental().getRentalDate());
                rentalResponse.setReturnDate(i.getRental().getReturnDate());

                rentalResponseList.add(rentalResponse);
            }
        }

        return rentalResponseList;

    }
}
