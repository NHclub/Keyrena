package com.nhclub.keyrena.domain.comment.model.request;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Long postId;
    private String content;
    private String link;
}
