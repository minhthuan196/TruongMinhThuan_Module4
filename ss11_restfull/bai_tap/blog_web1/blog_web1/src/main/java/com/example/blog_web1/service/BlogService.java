package com.example.blog_web1.service;


import com.example.blog_web1.model.Blog;
import com.example.blog_web1.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Blog> displayAllBlog(String name, Pageable pageable) {
        return blogRepository.search("%" + name + "%", pageable);
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

    @Override
    public List<Blog> findBlogsByCategoryBlog(int id) {
        return blogRepository.findBlogsByCategoryBlog(id);
    }

    @Override
    public Page<Blog> searchByCategory(Pageable pageable, int id) {
        return  blogRepository.searchByCategory(pageable, id);
    }

    @Override
    public Page<Blog> searchByCategoryAndName(String name, Pageable pageable, int id) {
        return blogRepository.searchByCategoryAndName("%" + name + "%", pageable,id);
    }
}
