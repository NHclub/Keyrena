package com.nhclub.keyrena.domain.post.model.request;

import com.nhclub.keyrena.domain.post.model.type.Category;
import lombok.Getter;

@Getter
public class PostRequestDto {

    private String link;
    private String title;
    private String content;
    private Category category;
}
