package com.nhclub.keyrena.domain.post.service;

import com.nhclub.keyrena.domain.post.model.entity.Post;
import com.nhclub.keyrena.domain.post.model.request.PostRequestDto;
import com.nhclub.keyrena.domain.post.model.response.PostResponseDto;
import com.nhclub.keyrena.domain.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    //게시글 전체 조회
    public List<PostResponseDto> getPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();

        for (Post post : posts) {
            postResponseDtoList.add(new PostResponseDto(post));
        }

        return postResponseDtoList;
    }

    //게시글 상세 조회
    public PostResponseDto getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("게시글이 존재하지 않습니다."));

        return new PostResponseDto(post);
    }

    //게시글 작성
    public void createPost(PostRequestDto postRequestDto) {
        postRepository.save(new Post(postRequestDto));
    }

    //게시글 수정
    @Transactional
    public void updatePost(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("게시글이 존재하지 않습니다."));

        post.updatePost(postRequestDto);
    }

    //게시글 삭제
    @Transactional
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("게시글이 존재하지 않습니다."));

        postRepository.delete(post);
    }
}
