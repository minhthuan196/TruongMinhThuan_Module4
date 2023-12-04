package com.example.blog_web.service;

import com.example.blog_web.model.Blog;
import com.example.blog_web.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> displayAllCategory();
    Category getCategory(int id);
    void saveCategory(Category category);
    void deleteCategory(int id);
}
