package com.bookstore.bookmanager.service;

import com.bookstore.bookmanager.dto.BookDTO;
import com.bookstore.bookmanager.entity.Book;
import com.bookstore.bookmanager.mapper.BookMapper;
import com.bookstore.bookmanager.repository.BookRepository;
import com.bookstore.bookmanager.utils.BookUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookService service;
    private final BookMapper mapper = BookMapper.INSTANCE;

    @Test
    void whenGivenExistingIdThenReturnThisBook() throws Exception {
        final Book fakeBook = BookUtils.createFakeBook();

        when(repository.findById(fakeBook.getId()))
                .thenReturn(Optional.of(fakeBook));

        BookDTO bookDTO = service.findById(fakeBook.getId());

        assertEquals(fakeBook.getName(), bookDTO.getName());
        assertEquals(fakeBook.getIsbn(), bookDTO.getIsbn());
        assertEquals(fakeBook.getPublisherName(), bookDTO.getPublisherName());
    }
}
