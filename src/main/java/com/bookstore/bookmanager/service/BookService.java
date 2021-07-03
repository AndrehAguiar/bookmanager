package com.bookstore.bookmanager.service;

import com.bookstore.bookmanager.dto.BookDTO;
import com.bookstore.bookmanager.dto.MessageResponseDTO;
import com.bookstore.bookmanager.entity.Book;
import com.bookstore.bookmanager.mapper.BookMapper;
import com.bookstore.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;
    private final BookMapper mapper = BookMapper.INSTANDE;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public MessageResponseDTO create(BookDTO bookDTO) {
        Book bookToSave = mapper.toModel(bookDTO);
        final Book savedbook = repository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with ID: " + savedbook.getId())
                .build();
    }

    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return repository.findAll();
    }
}
