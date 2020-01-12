package com.demo.java.demo.java;

import com.demo.java.demo.java.entity.Author;
import com.demo.java.demo.java.entity.Post;
import com.demo.java.demo.java.entity.PostDetail;
import com.demo.java.demo.java.repository.AuthorRepository;
import com.demo.java.demo.java.repository.PostDetailRepository;
import com.demo.java.demo.java.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AuthorRepository authorRepository;
    private final PostRepository postRepository;
    private final PostDetailRepository postDetailRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        var author1 = Author.builder().name("QuanNguyen1").age(25).build();
        var author2 = Author.builder().name("QuanNguyen2").age(26).build();
        var author3 = Author.builder().name("QuanNguyen3").age(27).build();
        var author4 = Author.builder().name("QuanNguyen4").age(26).build();
        var author5 = Author.builder().name("QuanNguyen5").age(27).build();
        var author6 = Author.builder().name("QuanNguyen6").age(26).build();
        var author7 = Author.builder().name("QuanNguyen7").age(27).build();

       var authors = Arrays.asList(author1,author2,author3,author4,author5,author6,author7);
       var savedAuthors = authorRepository.saveAll(authors);

        for (var savedAuthor: savedAuthors) {
            for (var i=1;i < 20;i++) {
                var post1 = Post.builder().author(savedAuthor).title("How to became better Developer. " + i)
                        .postType(Post.TYPE.NEW)
                        .createdBy(savedAuthor.getName())
                        .createdOn(new Date())
                        .build();
                var postDetail1 =  PostDetail.builder()
                        .content("Dev every day." + i)
                        .build();
                postDetail1.setPost(post1);
                post1.setDetail(postDetail1);

                postRepository.save(post1);
            }
        }
    }
}
