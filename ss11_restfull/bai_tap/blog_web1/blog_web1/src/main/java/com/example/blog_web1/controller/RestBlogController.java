package com.example.blog_web1.controller;

import com.example.blog_web1.model.Blog;
import com.example.blog_web1.model.Category;
import com.example.blog_web1.service.IBlogService;
import com.example.blog_web1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> findAllCategory() {
        List<Category> categoryList = categoryService.displayAllCategory();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

//    @GetMapping("/blog")
//    public ResponseEntity<List<Blog>> findAllBlog() {
//        List<Blog> blogList = blogService.displayAllBlog();
//        if (blogList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<List<Blog>> getCategoryDetail(@PathVariable int id) {
        List<Blog> blogList = blogService.findBlogsByCategoryBlog(id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/blog/detail/{id}")
    public ResponseEntity<Blog> getBlogDetail(@PathVariable int id) {
        Blog blog = blogService.displayBlogById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<Page<Blog>> findAllBlog(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "") String name,
                                                  @RequestParam(defaultValue = "0") int id) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("post_date").descending()
                .and(Sort.by("name").ascending()));
        Page<Blog> blogPage;
        List<Category> categoryList = categoryService.displayAllCategory();
        if (id == 0) {
            blogPage = blogService.displayAllBlog(name, pageable);
        } else {
            blogPage = blogService.searchByCategoryAndName(name, pageable, id);
        }
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
}
