package com.bookstore.bookmanager.service;

import com.bookstore.bookmanager.dto.MessageResponseDTO;
import com.bookstore.bookmanager.entity.Book;
import com.bookstore.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public MessageResponseDTO create(Book book) {
        final Book savedbook = repository.save(book);
        return MessageResponseDTO.builder()
                .message("Book created with ID: " + savedbook.getId())
                .build();
    }
}
