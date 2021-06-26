package com.book.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter
public class BookDTO {
    private Long id;

    private String categoryName;

    private String name;

    private int stockQuantity;

    private String author;
}
