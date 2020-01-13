package com.demo.java.demo.java.controller;

import com.demo.java.demo.java.dto.AuthorDto;
import com.demo.java.demo.java.dto.AuthorMapper;
import com.demo.java.demo.java.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService service;
    private final AuthorMapper mapper;

    @GetMapping("/1")
    public List<AuthorDto> getAuthors(Pageable pageable){
        return mapper.toListDto(service.listAuthor(pageable));
    }

    @GetMapping("/2")
    public List<AuthorDto> getAuthors2(Pageable pageable){
        return mapper.toListDto(service.listAuthor2(pageable));
    }
}
