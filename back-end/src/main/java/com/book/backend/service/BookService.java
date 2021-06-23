package com.book.backend.service;

import com.book.backend.domain.Book;
import com.book.backend.domain.Category;
import com.book.backend.domain.RequestAddBook;
import com.book.backend.repository.BookRepository;
import com.book.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BookService(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }
    
    // 도서 등록
    public String addBook(RequestAddBook addBook) {

        String msg = null;

        // 도서 분류 목록확인
        Optional<Category> category_result = categoryRepository.findByName(addBook.getCategory_name());
        if (category_result.isEmpty()) { // 분류 목록 없을 때
            msg = "도서 분류 정보가 잘못 됬습니다.";
        }else { // 분류 목록 있을 때
            Book book = new Book();

            // 도서 검색
            Optional<Book> findBook = bookRepository.findByName(addBook.getBook_name());

            if (findBook.isEmpty()) { // 같은 도서 없으면 새 도서 등록
                book.setStockQuantity(addBook.getStockQuantity());

                book.setName(addBook.getBook_name());
                book.setAuthor(addBook.getAuthor());

                Long category_id = category_result.get().getId();
                Category category = new Category();
                category.setId(category_id);
                book.setCategory(category);


                msg = "도서가 등록되었습니다.";
            } else { // 같은 도서 있으면 재고 추가
                book.setStockQuantity(addBook.getStockQuantity() + findBook.get().getStockQuantity());

                book.setId(findBook.get().getId());
                book.setName(addBook.getBook_name());
                book.setAuthor(addBook.getAuthor());

                Long category_id = category_result.get().getId();
                Category category = new Category();
                category.setId(category_id);
                book.setCategory(category);

                msg = "재고가 수정되었습니다.";
            }

            bookRepository.save(book);
        }
        
        return msg;
    }


    // 도서 재고 수량 증가
    public void addStockQuantity(String book_name, int stockQuantity) {

    }

    // 도서 재고 수량 감소

}
