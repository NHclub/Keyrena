package com.nhclub.keyrena.domain.comment.controller;

import com.nhclub.keyrena.domain.comment.model.request.CommentRequestDto;
import com.nhclub.keyrena.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //댓글 작성
    @PostMapping("/comment")
    public void createComment(@RequestBody CommentRequestDto commentRequestDto) {
        commentService.createComment(commentRequestDto);
    }

    //댓글 수정
    @PutMapping("/comment/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto) {
        commentService.updateComment(id, commentRequestDto);
    }

    //댓글 삭제
    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
