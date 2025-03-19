package com.example.graphQL.controller;

import com.example.graphQL.entity.Post;
import com.example.graphQL.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @QueryMapping
    public List<Post> posts() {
        return postService.getAllPosts();
    }

    @QueryMapping
    public Post post(@Argument Long id) {
        return postService.getPostById(id);
    }

    @MutationMapping
    public Post createPost(@Argument String title, @Argument String content, @Argument String author) {
        return postService.createPost(title, content, author);
    }

    @MutationMapping
    public Post updatePost(@Argument Long id, @Argument String title, @Argument String content, @Argument String author) {
        return postService.updatePost(id, title, content, author);
    }

    @MutationMapping
    public boolean deletePost(@Argument Long id) {
        return postService.deletePost(id);
    }
}

