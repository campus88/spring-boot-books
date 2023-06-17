package com.campus.spring.book.controller;

import com.campus.spring.base.exeption.ResourceNotFoundException;
import com.campus.spring.book.entity.BookEntity;
import com.campus.spring.book.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookApiController {

    private final BookService bookService;

    public BookApiController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String ok(){
        return "ok";
    }

    @GetMapping("/api/v1/book")
    public List<BookEntity> all(){
        return bookService.all();
    }

    @GetMapping("/api/v1/book/{id}")
    public BookEntity byId(@PathVariable Integer id){
        return bookService.byId(id).orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping("/api/v1/book")
    public BookEntity create(@RequestBody BookEntity book){
        return bookService.create(book.getTitle(), book.getDescription());
    }

    @PutMapping("/api/v1/book/{id}")
    public BookEntity edit(@PathVariable Integer id, @RequestBody BookEntity book){
        return bookService.edit(book).orElseThrow(ResourceNotFoundException::new);
    }
}
