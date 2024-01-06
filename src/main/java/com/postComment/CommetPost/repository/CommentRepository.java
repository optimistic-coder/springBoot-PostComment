package com.postComment.CommetPost.repository;

import com.postComment.CommetPost.entity.Comment;
import com.postComment.CommetPost.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPostid(Integer postid);
}
