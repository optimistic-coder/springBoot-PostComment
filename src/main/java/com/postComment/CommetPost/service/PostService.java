package com.postComment.CommetPost.service;

import com.postComment.CommetPost.entity.Comment;
import com.postComment.CommetPost.entity.Post;
import com.postComment.CommetPost.repository.CommentRepository;
import com.postComment.CommetPost.repository.PostRepository;
import org.hibernate.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepo;

    @Autowired
    CommentRepository commentRepo;

    public String createPost(Post  post){
       try{
        postRepo.save(post);
        return"post created";
       }catch (Exception e){
           return "Something went wrong";
       }
    }
    public String deletePost(Integer  postId){
        try{
            postRepo.deleteById(postId);
            return"post deleted";
        }catch (Exception e){
            return "Something went wrong";
        }
    }

    public String createComment(Comment comment){
         commentRepo.save(comment);
        return "comment saved";
    }

    public String deleteComment(Integer comment){
        commentRepo.deleteById(comment);
        return "comment saved";
    }

    public List<Post> getAllPost(){
        postRepo.findAll();
        return postRepo.findAll();
    }

    public List<Comment> getComments(){
        return commentRepo.findAll();
    }

    public List<Post> getpostsWithComments(String pageNumber,String pageSize){

      List<Post> posts =  postRepo.findAll(PageRequest.of(Integer.parseInt(pageNumber),Integer.parseInt(pageSize))).getContent();

      for (Post post:posts){
          System.out.println(post.getPostId());
          List<Comment> commentsOfPost = commentRepo.findByPostid(post.getPostId());
          System.out.println(commentsOfPost.size());
          if(commentsOfPost.size()>0){
              post.setComments(commentsOfPost);
          }
      }

        return posts;
    }
}
