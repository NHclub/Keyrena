package com.nhclub.keyrena.domain.post.model.entity;

import com.nhclub.keyrena.domain.comment.model.entity.Comment;
import com.nhclub.keyrena.domain.post.model.request.PostRequestDto;
import com.nhclub.keyrena.domain.post.model.type.Category;
import com.nhclub.keyrena.global.timestamp.Timestamp;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "link", nullable = false)
    private String link;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "post",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @OrderBy("createdAt desc")
    private List<Comment> commentList = new ArrayList<>();

    public Post(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.link = postRequestDto.getLink();
        this.category = postRequestDto.getCategory();
    }

    public void updatePost(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.category = postRequestDto.getCategory();
    }
}
