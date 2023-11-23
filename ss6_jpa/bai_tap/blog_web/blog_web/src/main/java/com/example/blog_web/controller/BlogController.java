package com.example.blog_web.controller;

import com.example.blog_web.model.Blog;
import com.example.blog_web.model.Category;
import com.example.blog_web.service.IBlogService;
import com.example.blog_web.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String showBlog(Model model,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "") String name,
                           @RequestParam(defaultValue = "0") int id) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("post_date").descending()
                .and(Sort.by("name").ascending()));
        Page<Blog> blogPage;
        Category category = null;
        List<Category> categoryList = categoryService.displayAllCategory();
        if (id == 0) {
            blogPage = blogService.displayAllBlog(name, pageable);
        } else {
            blogPage = blogService.searchByCategoryAndName(name, pageable, id);
            category = categoryService.getCategory(id);
        }
        model.addAttribute("category", category);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("name", name);
        model.addAttribute("categoryList", categoryList);
        return "blog/list";
    }

    @GetMapping("/create")
    public String showFromCreate(Model model) {
        List<Category> categoryList = categoryService.displayAllCategory();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(RedirectAttributes redirectAttributes, Blog blog) {
        blog.setPostDate(String.valueOf(LocalDateTime.now()));
        blogService.createBlog(blog);
        redirectAttributes.addFlashAttribute("mess", "add blog success!!!");
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam int id) {
        Blog blog = blogService.displayBlogById(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }

    @GetMapping("/edit")
    public String showFromEdit(Model model, @RequestParam int id) {
        Blog blog = blogService.displayBlogById(id);
        List<Category> categoryList = categoryService.displayAllCategory();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", blog);
        return "blog/edit";
    }

    @PostMapping("/update")
    public String updateProduct(RedirectAttributes redirectAttributes, Blog blog) {
        blog.setPostDate(String.valueOf(LocalDateTime.now()));
        blogService.updateBlog(blog);
        redirectAttributes.addFlashAttribute("mess", "update blog success!!!");
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String delete(RedirectAttributes redirectAttributes, @RequestParam int id) {
        blogService.deleteBlog(id);
        redirectAttributes.addFlashAttribute("mess", "delete blog success!!!");
        return "redirect:/blog";
    }
}
