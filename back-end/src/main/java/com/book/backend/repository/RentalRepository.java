package com.book.backend.repository;

import com.book.backend.domain.Rental;
import com.book.backend.domain.RentalItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    public void getRentalList() {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<RentalItem> cq = cb.createQuery(RentalItem.class);
//        Root<RentalItem> o = cq.from(RentalItem.class);
//        Join<Object, Object> m = o.join("rental", JoinType.INNER);
//
//        List<Predicate> criteria = new ArrayList<>();

        // 카테고리 검색
//        if (category != null) {
//            Predicate cat = cb.equal(o.get("category"), category);
//            criteria.add(cat);
//        }
//
//        // 카테고리 검색
//        if (category != null) {
//            Predicate cat = cb.equal(o.get("category"), category);
//            criteria.add(cat);
//        }
//
//        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
//        TypedQuery<Book> query = em.createQuery(cq);
//        return query.getResultList();
    }
}
