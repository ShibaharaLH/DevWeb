/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prototipoRedeSocial.models;

/**
 *
 * @author kono
 */
public class PostComment {
    
    private int idPostComment;
    private int idPost;
    private String commentValue;
    private String email;

    public PostComment(int idPostComment, int idPost, String commentValue, String email) {
        this.idPostComment = idPostComment;
        this.idPost = idPost;
        this.commentValue = commentValue;
        this.email = email;
    }

    public int getIdPostComment() {
        return idPostComment;
    }

    public void setIdPostComment(int idPostComment) {
        this.idPostComment = idPostComment;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getCommentValue() {
        return commentValue;
    }

    public void setCommentValue(String commentValue) {
        this.commentValue = commentValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
