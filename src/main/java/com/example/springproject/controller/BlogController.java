package com.example.springproject.controller;
import com.example.springproject.dto.BlogDto;
import com.example.springproject.maneger.BlogManager;
import com.example.springproject.service.BlogService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    private final BlogService service;
    public BlogController(BlogManager service) {
        this.service = service;
    }
    @GetMapping("/{id}")
    BlogDto findById(@PathVariable int id){
       return service.findById(id);
    }
    @PostMapping("/add")
    void addBlog(@RequestBody BlogDto blog){
        service.addBlog(blog);
    }
    @DeleteMapping("/delete/{id}")
    void deleteBlog(@PathVariable int id){
        service.deleteBlog(id);
    }
}
