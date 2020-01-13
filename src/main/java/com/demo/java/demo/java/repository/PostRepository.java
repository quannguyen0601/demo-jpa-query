package com.demo.java.demo.java.repository;

import com.demo.java.demo.java.dto.PostDataDto;
import com.demo.java.demo.java.dto.PostDataMiniDto;
import com.demo.java.demo.java.entity.Author;
import com.demo.java.demo.java.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    //Stupid
//    List<Post> findAllByCreatedOnDesc(Pageable pageable);

    //Not stupid 1
    @Query("SELECT p FROM Post p inner join fetch p.detail d inner join fetch p.author a order by p.createdOn desc")
    List<Post> customQueryFindAll2(Pageable pageable);


    @EntityGraph(value = "allPostOrderByCreateOnDesc")
    @Query("SELECT p FROM Post p ORDER BY p.createdOn desc")
    List<Post> customQuery3(Pageable pageable);


    @Query("SELECT new com.demo.java.demo.java.dto.PostDataDto(p.id,p.title," +
            "p.createdOn,p.createdBy,d.content,a.name,a.age,p.postType) " +
            "FROM Post p inner join p.detail d inner join p.author a order by p.createdOn desc ")
    List<PostDataDto> customQueryFindAll4(Pageable pageable);

//    @Query("SELECT new com.demo.java.demo.java.dto.PostDataMiniDto(p.id,p.title," +
//            "p.createdOn,p.createdBy,p.postType) " +
//            "FROM Post p order by p.createdOn desc ")
    List<Post> findTop10ByAuthor_IdOrderByCreatedOnDesc(Long authorId);

        @Query("SELECT new com.demo.java.demo.java.entity.Post(p.id,p.title," +
            "p.createdOn,p.createdBy,p.postType) " +
            "FROM Post p WHERE p.author.id = ?1 order by p.createdOn desc")
    List<Post> findTop10ByAuthor_IdOrderByCreatedOnDesc2(Long authorId,Pageable pageable);
}
