package com.example.blog_web1.service;



import com.example.blog_web1.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> displayAllCategory();
    Category getCategory(int id);
    void saveCategory(Category category);
    void deleteCategory(int id);
}
