package com.example.crm.entity;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/17 15:05
 * @ Description：评论实体类
 * @ Modified By：
 */
public class Comment {
    //评论Id
    private Integer commentId;
    //评论
    private String comment;
    //用户
    private User user;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
