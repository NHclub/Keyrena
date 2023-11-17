package com.nhclub.keyrena.domain.post.controller;

import com.nhclub.keyrena.domain.post.model.request.PostRequestDto;
import com.nhclub.keyrena.domain.post.model.response.PostResponseDto;
import com.nhclub.keyrena.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    //게시글 전체 조회
    @GetMapping("/posts")
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }

    //게시글 상세 조회
    @GetMapping("/post/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    //게시글 작성
    @PostMapping("/post")
    public void createPost(@RequestBody PostRequestDto postRequestDto) {
        postService.createPost(postRequestDto);
    }

    //게시글 수정
    @PutMapping("/post/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        postService.updatePost(id, postRequestDto);
    }

    //게시글 삭제
    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
