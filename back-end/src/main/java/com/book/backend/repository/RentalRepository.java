package com.book.backend.repository;

import com.book.backend.domain.Rental;
import com.book.backend.domain.RentalSearch;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RentalRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Rental rental) {
        em.persist(rental);
    }

    public Rental findById(Long rentalId) {
        return em.find(Rental.class, rentalId);
    }
}
