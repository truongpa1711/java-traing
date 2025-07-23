package com.example.demo.controller;

import com.example.demo.entity.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/webclient")
public class WebClientController {
    private final WebClient webClient;

    public WebClientController(WebClient webClient) {
        this.webClient = webClient;
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost() {
        try {
            Post post = new Post();
            post.setTitle("foo");
            post.setBody("bar");
            post.setUserId(1L);

            Post response = webClient.post()
                    .uri("/posts")
                    .bodyValue(post)
                    .retrieve()
                    .bodyToMono(Post.class)
                    .block();

            System.out.println("✅ Post created: " + response);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            System.err.println("❌ Error creating post: " + ex.getMessage());
            return ResponseEntity.status(502).build();
        }
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts() {
        try {
            List<Post> posts = webClient.get()
                    .uri("/posts")
                    .retrieve()
                    .bodyToFlux(Post.class)
                    .collectList()
                    .block();

            return ResponseEntity.ok(posts);
        } catch (Exception ex) {
            System.err.println("❌ Error retrieving posts: " + ex.getMessage());
            return ResponseEntity.status(502).body(List.of());
        }
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        try {
            Post post = webClient.get()
                    .uri("/posts/{id}", id)
                    .retrieve()
                    .bodyToMono(Post.class)
                    .block();

            return ResponseEntity.ok(post);
        } catch (Exception ex) {
            System.err.println("❌ Error retrieving post by ID: " + ex.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        try {
            Post updated = webClient.put()
                    .uri("/posts/{id}", id)
                    .bodyValue(post)
                    .retrieve()
                    .bodyToMono(Post.class)
                    .block();

            System.out.println("✅ Post updated: " + updated);
            return ResponseEntity.ok(updated);
        } catch (Exception ex) {
            System.err.println("❌ Error updating post: " + ex.getMessage());
            return ResponseEntity.status(502).build();
        }
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        try {
            webClient.delete()
                    .uri("/posts/{id}", id)
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block();

            System.out.println("✅ Post deleted with ID: " + id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            System.err.println("❌ Error deleting post: " + ex.getMessage());
            return ResponseEntity.status(502).build();
        }
    }
}
