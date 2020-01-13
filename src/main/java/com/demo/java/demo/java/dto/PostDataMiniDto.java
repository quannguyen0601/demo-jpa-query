package com.demo.java.demo.java.dto;

import com.demo.java.demo.java.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDataMiniDto {
    private Long id;
    private String title;
    private Date createdOn;
    private String createdBy;
    private Post.TYPE postType;

    public PostDataMiniDto(Long id,String title, Date createdOn, String createdBy, Post.TYPE type) {
        this.id = id;
        this.title = title;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.postType = type;
    }
}
