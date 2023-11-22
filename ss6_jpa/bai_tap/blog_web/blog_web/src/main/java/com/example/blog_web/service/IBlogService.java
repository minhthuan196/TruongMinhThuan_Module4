package com.example.blog_web.service;

import com.example.blog_web.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> displayAllBlog();

    Blog displayBlogById(int id);

    void createBlog(Blog blog);

    void updateBlog(Blog blog);

    void deleteBlog(int id);

    List<Blog> searchBlogByName(String name);
}
