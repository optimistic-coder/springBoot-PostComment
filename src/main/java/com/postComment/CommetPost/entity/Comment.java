package com.postComment.CommetPost.entity;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private Integer postid;
    private String content;

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @ManyToOne // Assuming many comments can belong to one post
    @JoinColumn(name = "post_id")
    private Post post;
}
