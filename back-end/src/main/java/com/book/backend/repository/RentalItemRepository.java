package com.book.backend.repository;

import com.book.backend.domain.Book;
import com.book.backend.domain.Rental;
import com.book.backend.domain.RentalItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RentalItemRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(RentalItem rentalItem) {
        em.persist(rentalItem);
    }

    public List<RentalItem> findAll(Book book) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<RentalItem> cq = cb.createQuery(RentalItem.class);
        Root<RentalItem> o = cq.from(RentalItem.class);
        Join<Object, Object> m = o.join("rental", JoinType.INNER);

        List<Predicate> criteria = new ArrayList<>();

        // 카테고리 검색
        if (book != null) {
            Predicate cat = cb.equal(o.get("book"), book);
            criteria.add(cat);
        }

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        cq.orderBy(cb.desc(o.get("id")));
        TypedQuery<RentalItem> query = em.createQuery(cq);
        return query.getResultList();
    }

    public List<RentalItem> findByRental(Rental rental) {
        return em.createQuery("select ri from RentalItem ri where ri.rental = :rental")
                .setParameter("rental", rental)
                .getResultList();
    }
}
