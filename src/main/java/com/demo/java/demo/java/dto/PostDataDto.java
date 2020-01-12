package com.demo.java.demo.java.dto;

import com.demo.java.demo.java.entity.Post;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class PostDataDto {
    private Long id;
    private String title;
    private Date createdOn;
    private String createdBy;
    private String content;
    private String authorName;
    private int authorAge;
    private Post.TYPE postType;

    public PostDataDto(Long id,String title, Date createdOn, String createdBy, String content, String authorName, int authorAge, Post.TYPE type) {
        this.id = id;
        this.title = title;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.content = content;
        this.authorName = authorName;
        this.authorAge = authorAge;
        this.postType = type;
    }
}
