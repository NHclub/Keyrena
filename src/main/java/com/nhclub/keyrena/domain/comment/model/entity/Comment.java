package com.nhclub.keyrena.domain.comment.model.entity;

import com.nhclub.keyrena.domain.comment.model.request.CommentRequestDto;
import com.nhclub.keyrena.domain.post.model.entity.Post;
import com.nhclub.keyrena.global.timestamp.Timestamp;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "link", nullable = false)
    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public Comment(CommentRequestDto commentRequestDto, Post post) {
        this.content = commentRequestDto.getContent();
        this.link = commentRequestDto.getLink();
        this.post = post;
    }

    public void updateComment(CommentRequestDto commentRequestDto){
        this.content = commentRequestDto.getContent();
    }
}
