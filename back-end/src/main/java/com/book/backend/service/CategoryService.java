package com.book.backend.service;

import com.book.backend.domain.Category;
import com.book.backend.domain.CategoryDTO;
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


    /**
     * 카테고리 리스트 조회
     */
    public List<CategoryDTO> getCategoryList() {
        List<Category> categoryList = categoryRepository.findAll();

        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category c : categoryList) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(c.getId());
            categoryDTO.setName(c.getName());

            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }
}
