package com.nhclub.keyrena.domain.post.model.response;

import com.nhclub.keyrena.domain.post.model.entity.Post;
import com.nhclub.keyrena.domain.post.model.type.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostResponseDto {

    private Long id;
    private String title;
    private String content;
    private String link;
    private Category category;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAy;
//    private List<CommentResponseDto> commentList;


    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.link = post.getLink();
        this.category = post.getCategory();
        this.createdAt = post.getCreatedAt();
        this.modifiedAy = post.getModifiedAt();
    }
}
