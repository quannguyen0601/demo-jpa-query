package com.demo.java.demo.java.controller;

import com.demo.java.demo.java.dto.PostDataDto;
import com.demo.java.demo.java.dto.PostMapper;
import com.demo.java.demo.java.entity.Post;
import com.demo.java.demo.java.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostMapper mapper;
    private final PostService service;

    @GetMapping("/")
    public List<PostDataDto> demoQuery1(Pageable pageable, @RequestParam int type) {
        switch (type){
            case 2:
                return  mapper.toListDto(service.queryPost2(pageable));
            case 3:
                return  mapper.toListDto(service.queryPost3(pageable));
            case 4:
                return  service.queryPost4(pageable);
            default:
                return  mapper.toListDto(service.queryPost1(pageable));
        }

    }
}
