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
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository repository;
    private final BookMapper mapper = BookMapper.INSTANCE;

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
    public List<BookDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BookDTO findById(Long id) throws Exception {
        return mapper.toDTO(repository.findById(id)
                .orElseThrow(() -> new Exception("Book not found!")));
    }
}
