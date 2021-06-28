package com.book.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "book_name", unique = true)
    private String name;

    private int stockQuantity;

    private String author;

    /**
     * 재고 증가
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * 재고 감소
     */
    public String removeStock(int quantity) {
        String msg = null;
        if (this.stockQuantity == 0) {
            msg = "재고가 없습니다.";
        } else {
            this.stockQuantity -= quantity;
        }

        return msg;
    }
}
