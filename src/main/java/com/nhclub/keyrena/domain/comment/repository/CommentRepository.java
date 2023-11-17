package com.nhclub.keyrena.domain.comment.repository;

import com.nhclub.keyrena.domain.comment.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
