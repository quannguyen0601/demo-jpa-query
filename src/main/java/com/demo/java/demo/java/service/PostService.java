package com.demo.java.demo.java.service;

import com.demo.java.demo.java.dto.PostDataDto;
import com.demo.java.demo.java.entity.Post;
import com.demo.java.demo.java.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;

    public List<Post> queryPost1(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }
    public List<Post> queryPost2(Pageable pageable) {
        return repository.customQueryFindAll2(pageable);
    }
    public List<Post> queryPost3(Pageable pageable) {
        return repository.customQuery3(pageable);
    }
    public List<PostDataDto> queryPost4(Pageable pageable) {
        return repository.customQueryFindAll4(pageable);
    }
}
