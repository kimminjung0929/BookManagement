package com.book.backend.repository;

import com.book.backend.domain.RentalItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RentalItemRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(RentalItem rentalItem) {
        em.persist(rentalItem);


    }
}
