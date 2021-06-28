package com.book.backend.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RentalRepository {

    @PersistenceContext
    private EntityManager em;
}
