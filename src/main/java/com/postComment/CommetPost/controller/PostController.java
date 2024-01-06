package com.postComment.CommetPost.controller;

import com.postComment.CommetPost.entity.Comment;
import com.postComment.CommetPost.entity.Post;
import com.postComment.CommetPost.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;
    @GetMapping("/Allposts")
    public List<Post> getposts() {
        return postService.getAllPost();
    }

    @PostMapping("/createPost")
    public String createPosts(@RequestBody Post post){
        return postService.createPost(post);
    }

    @GetMapping("/delete/{postId}")
    public String deletePosts(@PathVariable Integer postId){
        System.out.println("45435345"+postId);
        return postService.deletePost(postId);
    }

    @PostMapping("/createComment")
    public String createComments(@RequestBody Comment comment){
        return postService.createComment(comment);
    }

    @GetMapping("/deleteComment/{id}")
    public String deleteComments(@PathVariable String id){
        System.out.println("45435345"+"cid"+id);
        return "cid";
    }


    @GetMapping("/getComments")
    public List<Comment> getComments(){

        return postService.getComments();
    }

    @GetMapping("/getPostWithComments/{pageNumber}/{pageSize}")
    public List<Post> getPostWithComment(@PathVariable String pageNumber, @PathVariable String pageSize){

        return postService.getpostsWithComments(pageNumber,pageSize);
    }

}
