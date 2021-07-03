package com.bookstore.bookmanager.controller;

import com.bookstore.bookmanager.dto.MessageResponseDTO;
import com.bookstore.bookmanager.entity.Book;
import com.bookstore.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookRepository repository;

    @Autowired
    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody Book book) {
        final Book savedbook = repository.save(book);
        return MessageResponseDTO.builder()
                .message("Book created with ID: " + savedbook.getId())
                .build();
    }

}
