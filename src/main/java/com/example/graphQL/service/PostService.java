package com.example.graphQL.service;

import com.example.graphQL.Repository.PostRepository;
import com.example.graphQL.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post createPost(String title, String content, String author) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(author);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    public Post updatePost(Long id, String title, String content, String author) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            if (title != null) post.setTitle(title);
            if (content != null) post.setContent(content);
            if (author != null) post.setAuthor(author);
            post.setUpdatedAt(LocalDateTime.now());
            return postRepository.save(post);
        }
        return null;
    }

    public boolean deletePost(Long id) {
        postRepository.deleteById(id);
        return true;
    }
}

