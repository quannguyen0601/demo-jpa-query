package com.demo.java.demo.java.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDto {
    private Long id;
    private String name;
    private int age;
    private List<PostDataMiniDto> top10posts;
}
