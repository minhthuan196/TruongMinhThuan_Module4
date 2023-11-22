package com.example.blog_web.repository;

import com.example.blog_web.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findBlogsByNameContaining(String name);
}
