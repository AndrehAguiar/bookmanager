package com.bookstore.bookmanager.controller;

import com.bookstore.bookmanager.dto.BookDTO;
import com.bookstore.bookmanager.dto.MessageResponseDTO;
import com.bookstore.bookmanager.entity.Book;
import com.bookstore.bookmanager.exception.BookNotFoundException;
import com.bookstore.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
        return service.create(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) throws BookNotFoundException {
        return service.findById(id);
    }

    @GetMapping
    public List<BookDTO> findAll(){
        return service.findAll();
    }

}
