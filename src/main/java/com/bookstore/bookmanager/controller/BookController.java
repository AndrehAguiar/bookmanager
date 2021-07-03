package com.bookstore.bookmanager.controller;

import com.bookstore.bookmanager.dto.MessageResponseDTO;
import com.bookstore.bookmanager.entity.Book;
import com.bookstore.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody Book book) {
        return service.create(book);
    }

    @GetMapping
    public List<Book> findAll(){
        return null;
    }

}
