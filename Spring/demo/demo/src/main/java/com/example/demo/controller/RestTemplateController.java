package com.example.demo.controller;

import com.example.demo.entity.Post;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/resttemplate")
public class RestTemplateController {
    private final RestTemplate restTemplate;

    public RestTemplateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/posts")
    public Post[] getPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        return restTemplate.getForObject(url, Post[].class);
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable Long id) {
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        return restTemplate.getForObject(url, Post.class, id);
    }

    @PostMapping("/posts")
    public Post createPost() {
        Post post = new Post();
        post.setTitle("foo");
        post.setBody("bar");
        post.setUserId(1L);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization","");
        HttpEntity<Post> requestEntity = new HttpEntity<>(post, headers);

        ResponseEntity<Post> responseEntity = restTemplate.postForEntity(
                "https://jsonplaceholder.typicode.com/posts",
                requestEntity,
                Post.class
        );
        System.out.println(responseEntity);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Failed to create post: " + responseEntity.getStatusCode());
        }
    }



}
