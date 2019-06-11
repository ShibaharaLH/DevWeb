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
public class SubCommentPost {
    
    private int idSubCommentPost;
    private int idCommentPost;
    private int idPost;
    private String subCommentValue;
    private String email;

    public SubCommentPost(int idSubCommentPost, int idCommentPost, int idPost, String subCommentValue, String email) {
        this.idSubCommentPost = idSubCommentPost;
        this.idCommentPost = idCommentPost;
        this.idPost = idPost;
        this.subCommentValue = subCommentValue;
        this.email = email;
    }

    public int getIdSubCommentPost() {
        return idSubCommentPost;
    }

    public void setIdSubCommentPost(int idSubCommentPost) {
        this.idSubCommentPost = idSubCommentPost;
    }

    public int getIdCommentPost() {
        return idCommentPost;
    }

    public void setIdCommentPost(int idCommentPost) {
        this.idCommentPost = idCommentPost;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getSubCommentValue() {
        return subCommentValue;
    }

    public void setSubCommentValue(String subCommentValue) {
        this.subCommentValue = subCommentValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
