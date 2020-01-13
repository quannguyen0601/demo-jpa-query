package com.demo.java.demo.java.repository;

import com.demo.java.demo.java.entity.PostDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDetailRepository extends JpaRepository<PostDetail,Long> {


}
