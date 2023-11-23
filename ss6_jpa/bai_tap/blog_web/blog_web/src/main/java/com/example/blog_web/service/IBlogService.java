package com.example.blog_web.service;

import com.example.blog_web.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

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
