package com.study.eatgo.application;

import com.study.eatgo.domain.Category;
import com.study.eatgo.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();

        return categories;
    }

}