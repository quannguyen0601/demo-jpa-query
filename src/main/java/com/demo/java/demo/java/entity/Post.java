package com.demo.java.demo.java.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Post")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
@NamedEntityGraph(name = "allPostOrderByCreateOnDesc",attributeNodes = {@NamedAttributeNode(value = "detail"), @NamedAttributeNode(value = "author")})
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "created_by")
    private String createdBy;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, mappedBy = "post")
    private PostDetail detail;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private Author author;

    @Enumerated
    @Column(length = 8, columnDefinition = "SMALLINT")
    private TYPE postType;

    public enum TYPE {
        DRAFT,
        NEW,
        PUBLIC
    }

    public Post(Long id,String title, Date createdOn, String createdBy, Post.TYPE type) {
        this.id = id;
        this.title = title;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.postType = type;
    }
}
