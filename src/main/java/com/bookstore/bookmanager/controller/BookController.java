package com.bookstore.bookmanager.controller;

import com.bookstore.bookmanager.dto.BookDTO;
import com.bookstore.bookmanager.dto.MessageResponseDTO;
import com.bookstore.bookmanager.exception.BookNotFoundException;
import com.bookstore.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> delete(@PathVariable Long id) throws BookNotFoundException {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.deleteById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable Long id) throws BookNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

}
