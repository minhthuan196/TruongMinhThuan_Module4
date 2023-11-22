package com.example.blog_web.service;

import com.example.blog_web.model.Blog;
import com.example.blog_web.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> displayAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Blog displayBlogById(int id) {
        return blogRepository.findById(id).orElse(null);
//        return blogRepository.findById(id).get();
    }

    @Override
    public void createBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void updateBlog(Blog blog) {
        if (blogRepository.existsById(blog.getId())) {
            blogRepository.save(blog);
        }
    }

    @Override
    public void deleteBlog(int id) {
        if (blogRepository.existsById(id)) {
            blogRepository.deleteById(id);
        }

    }

    @Override
    public List<Blog> searchBlogByName(String name) {
        return blogRepository.findBlogsByNameContaining(name);
    }
}
