package com.nhclub.keyrena.domain.comment.service;

import com.nhclub.keyrena.domain.comment.model.entity.Comment;
import com.nhclub.keyrena.domain.comment.model.request.CommentRequestDto;
import com.nhclub.keyrena.domain.comment.repository.CommentRepository;
import com.nhclub.keyrena.domain.post.model.entity.Post;
import com.nhclub.keyrena.domain.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    //댓글 작성
    public void createComment(CommentRequestDto commentRequestDto) {
        Post post = postRepository.findById(commentRequestDto.getPostId()).orElseThrow(() ->
                new NoSuchElementException("게시글이 존재하지 않습니다."));

        commentRepository.save(new Comment(commentRequestDto,post));
    }

    //댓글 수정
    @Transactional
    public void updateComment(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("댓글이 존재하지 않습니다."));

        comment.updateComment(commentRequestDto);

    }

    //댓글 삭제
    @Transactional
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("댓글이 존재하지 않습니다."));

        commentRepository.delete(comment);
    }
}
