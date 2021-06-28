package com.book.backend.repository;

import com.book.backend.domain.Book;
import com.book.backend.domain.BookSearch;
import com.book.backend.domain.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Book> findByName(String bookName) {
        return em.createQuery("select b from Book b where b.name = :name", Book.class)
                .setParameter("name", bookName)
                .getResultList();
    }

    /**
     * 도서 등록, 도서 재고 추가
     */
    public void save(Book book) {
        // 도서 등록 시 id가 없음, 재고 추가 시 id 있음
        if (book.getId() == null) {
            em.persist(book);    
        } else {
            em.merge(book);
        }
    }

    /**
     * 도서 이름으로 검색
     */
    public List<String> findName() {
        return em.createQuery("select b.name from Book b", String.class)
                .getResultList();
    }

    /**
     * JPA Criteria, 동적 쿼리 ( 카테고리 별 조회 )
     */
    public List<Book> findAll(Category category) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> o = cq.from(Book.class);
        Join<Object, Object> m = o.join("category", JoinType.INNER);

        List<Predicate> criteria = new ArrayList<>();

        // 카테고리 검색
        if (category != null) {
            Predicate cat = cb.equal(o.get("category"), category);
            criteria.add(cat);
        }

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Book> query = em.createQuery(cq);
        return query.getResultList();

    }
}
