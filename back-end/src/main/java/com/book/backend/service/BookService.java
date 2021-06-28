package com.book.backend.service;

import com.book.backend.domain.Book;
import com.book.backend.domain.BookDTO;
import com.book.backend.domain.BookSearch;
import com.book.backend.domain.Category;
import com.book.backend.repository.BookRepository;
import com.book.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BookService(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }


    /**
     * 도서 등록
     */
    @Transactional
    public String addBook(BookDTO addBook) {

        String msg = null;

        // 도서 분류 목록확인
        List<Category> category = categoryRepository.findByName(addBook.getCategoryName());

        if (category.size() == 0) { // 분류 목록에 없을 때
            msg = "도서 분류 정보가 잘못 됬습니다.";
        } else { // 분류 목록에 있을 때

            // 도서 검색
            List<Book> findBook = bookRepository.findByName(addBook.getName());

            if (findBook.isEmpty()) { // 같은 도서 없으면 새 도서 등록
                Book book = new Book();

                book.setStockQuantity(addBook.getStockQuantity());
                book.setName(addBook.getName());
                book.setAuthor(addBook.getAuthor());
                book.setCategory(category.get(0));

                bookRepository.save(book);

                msg = "도서가 등록되었습니다.";
            }
            else { // 같은 도서 있으면 재고 수정
                findBook.get(0).addStock(addBook.getStockQuantity());

                bookRepository.save(findBook.get(0));

                msg = "재고가 수정되었습니다.";
            }
        }
        return msg;
    }

    /**
     * 도서 조회
     */
    public List<BookDTO> bookList(BookSearch bookSearch) {
        Category category = null;
        if (!bookSearch.getCategoryName().equals("all")) {
            category = categoryRepository.findByName(bookSearch.getCategoryName()).get(0);
        }

        List<Book> bookList = bookRepository.findAll(category);

        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book b : bookList) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(b.getId());
            bookDTO.setName(b.getName());
            bookDTO.setAuthor(b.getAuthor());
            bookDTO.setCategoryName(b.getCategory().getName());
            bookDTO.setStockQuantity(b.getStockQuantity());

            bookDTOList.add(bookDTO);
        }

        return bookDTOList;
    }

    /**
     * 도서 이름 조회
     */
    public List<String> findBookName() {
        List<String> bookNameList = bookRepository.findName();

        return bookNameList;
    }
}
