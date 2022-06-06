package com.example.mfpspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private UserRepository userRepository;
    private PostRepository postRepository;

    @GetMapping(path = "/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping(path = "/posts/{postId}")
    public Post getPost(Long postId) {
        return postRepository.findPostById(postId);
    }

    @DeleteMapping("/posts/{postId}")
    public String deletePost(Long postId) {
        //In this place I figherred all fashists
        postRepository.deleteById(postId);
        return "Delete operation is finished successfully";
    }
}
