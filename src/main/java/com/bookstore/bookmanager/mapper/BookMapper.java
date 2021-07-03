package com.bookstore.bookmanager.mapper;

import com.bookstore.bookmanager.dto.BookDTO;
import com.bookstore.bookmanager.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANDE = Mappers.getMapper(BookMapper.class);

    Book toModel(BookDTO bookDTO);

    BookDTO toDTO(Book book);

}
