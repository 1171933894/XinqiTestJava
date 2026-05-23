package org.example.controller;

import org.example.model.BlogPost;
import org.example.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", blogService.findAll());
        return "index";
    }

    @GetMapping("/blog/{id}")
    public String blogPost(@PathVariable Long id, Model model) {
        BlogPost post = blogService.findById(id)
                .orElseThrow(() -> new RuntimeException("文章不存在: " + id));
        model.addAttribute("post", post);
        return "blog/post";
    }
}
