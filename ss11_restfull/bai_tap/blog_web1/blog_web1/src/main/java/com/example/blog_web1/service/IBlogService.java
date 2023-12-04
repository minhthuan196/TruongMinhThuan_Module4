package com.example.blog_web1.service;


import com.example.blog_web1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> displayAllBlog();

    Page<Blog> displayAllBlog(String name,Pageable pageable);

    Blog displayBlogById(int id);

    void createBlog(Blog blog);

    void updateBlog(Blog blog);

    void deleteBlog(int id);

    List<Blog> searchBlogByName(String name);

    List<Blog> findBlogsByCategoryBlog(int id);
    Page<Blog> searchByCategory(Pageable pageable,int id);
    Page<Blog> searchByCategoryAndName( String name,Pageable pageable, int id);
}
