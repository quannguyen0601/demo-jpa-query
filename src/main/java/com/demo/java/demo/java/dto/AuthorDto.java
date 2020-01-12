package com.demo.java.demo.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AuthorDto {
    private Long id;
    private String name;
    private int age;
}
