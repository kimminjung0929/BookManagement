package com.book.backend.repository;

import com.book.backend.domain.Category;
import com.book.backend.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @PersistenceContext
    private EntityManager em;

    /**
     * 전체 카테고리 조회 
     */
    public List<String> findAll() {
         List<String> results = em.createQuery("select c.name from Category c", String.class)
                .getResultList();

         return results;
    }

    /**
     * 카테고리 이름으로 조회
     */
    public List<Category> findByName(String categoryName) {
        List<Category> category = em.createQuery("select c from Category c where c.name = :name", Category.class)
                .setParameter("name", categoryName)
                .getResultList();

        return category;
    }

}
