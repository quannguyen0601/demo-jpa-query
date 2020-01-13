package com.demo.java.demo.java.service;

import com.demo.java.demo.java.dto.AuthorDto;
import com.demo.java.demo.java.entity.Author;
import com.demo.java.demo.java.repository.AuthorRepository;
import com.demo.java.demo.java.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final PostRepository postRepository;


    @Transactional(readOnly = true)
    public List<Author> listAuthor(Pageable pageable){
        var authors = authorRepository.findAllByOrderByIdDesc(pageable);
       return authors.stream()
               .peek(i -> i.setTop10posts(postRepository
                               .findTop10ByAuthor_IdOrderByCreatedOnDesc(i.getId())))
               .collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<Author> listAuthor2(Pageable pageable){
        var authors = authorRepository.findAllByOrderByIdDesc(pageable);
        return authors.stream()
                .peek(i -> i.setTop10posts(postRepository
                        .findTop10ByAuthor_IdOrderByCreatedOnDesc2(i.getId(),
                                PageRequest.of(0,10))))
                .collect(Collectors.toList());
    }

}
