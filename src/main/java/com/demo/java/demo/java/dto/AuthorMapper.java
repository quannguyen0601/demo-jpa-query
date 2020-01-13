package com.demo.java.demo.java.dto;

import com.demo.java.demo.java.entity.Author;
import com.demo.java.demo.java.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto toDto(Author author);

    List<AuthorDto> toListDto(List<Author> author);
}
