package com.demo.java.demo.java.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "post_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostDetail {
    @Id
    private Long id;

    private String content;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Post post;

}
