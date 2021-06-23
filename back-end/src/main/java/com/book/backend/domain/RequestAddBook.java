package com.book.backend.domain;

import lombok.Getter;

@Getter
public class RequestAddBook {
    private String book_name;

    private int stockQuantity;

    private String category_name;

    private String author;
}
