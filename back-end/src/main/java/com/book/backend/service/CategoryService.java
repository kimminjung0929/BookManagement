package com.book.backend.service;

import com.book.backend.domain.Category;
import com.book.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<String> getCategoryList() {
        List<Category> results = categoryRepository.findAll();
        List<String> category_names = new ArrayList<>();

        for (Category category : results) {
            category_names.add(category.getName());
        }

        return category_names;
    }

    public Optional<Category> getCategoryId(String category_name) {
        Optional<Category> category = categoryRepository.findByName(category_name);

        return category;
    }
}
