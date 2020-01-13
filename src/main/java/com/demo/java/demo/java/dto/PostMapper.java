package com.demo.java.demo.java.dto;

import com.demo.java.demo.java.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "content", source = "detail.content")
    @Mapping(target = "authorName", source = "author.name")
    @Mapping(target = "authorAge", source = "author.age")
    PostDataDto toDto(Post post);

    PostDataMiniDto toMiniDto(Post post);

    List<PostDataDto> toListDto(List<Post> post);
    List<PostDataMiniDto> toListMiniDto(List<Post> post);

}
