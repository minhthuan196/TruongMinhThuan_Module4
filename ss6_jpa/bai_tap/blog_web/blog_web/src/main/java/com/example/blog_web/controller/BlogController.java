package com.example.blog_web.controller;

import com.example.blog_web.model.Blog;
import com.example.blog_web.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public String showBlog(Model model) {
        List<Blog> blogList = blogService.displayAllBlog();
        model.addAttribute("blogList", blogList);
        return "blog/list";
    }

    @GetMapping("/create")
    public String showFromCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(RedirectAttributes redirectAttributes, Blog blog) {
        blogService.createBlog(blog);
        redirectAttributes.addFlashAttribute("success", "add blog success!!!");
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
        model.addAttribute("blog", blog);
        return "blog/edit";
    }

    @PostMapping("/update")
    public String updateProduct(RedirectAttributes redirectAttributes, Blog blog) {
        blogService.updateBlog(blog);
        redirectAttributes.addFlashAttribute("success", "update blog success!!!");
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String delete(RedirectAttributes redirectAttributes, @RequestParam int id) {
        blogService.deleteBlog(id);
        redirectAttributes.addFlashAttribute("success", "delete blog success!!!");
        return "redirect:/blog";
    }

    @PostMapping("/search")
    public String search(@RequestParam String name, Model model) {
        List<Blog> blogList = blogService.searchBlogByName(name);
        model.addAttribute("name", name);
        model.addAttribute("blogList", blogList);
        return "blog/list";
    }
}
