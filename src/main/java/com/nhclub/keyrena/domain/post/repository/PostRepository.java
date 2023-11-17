package com.nhclub.keyrena.domain.post.repository;

import com.nhclub.keyrena.domain.post.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
