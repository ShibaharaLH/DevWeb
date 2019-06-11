/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prototipoRedeSocial.DTO;

import java.util.List;

/**
 *
 * @author kono
 */
public class PostCommentDTO {
    
    private int idPostComment;
    private String CommentValue;
    private String email;
    private List<SubCommentPostDTO> listSubComment;

    public PostCommentDTO(int idPostComment, String CommentValue, String email, List<SubCommentPostDTO> listSubComment) {
        this.idPostComment = idPostComment;
        this.CommentValue = CommentValue;
        this.email = email;
        this.listSubComment = listSubComment;
    }

    public int getIdPostComment() {
        return idPostComment;
    }

    public void setIdPostComment(int idPostComment) {
        this.idPostComment = idPostComment;
    }

    public String getCommentValue() {
        return CommentValue;
    }

    public void setCommentValue(String CommentValue) {
        this.CommentValue = CommentValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SubCommentPostDTO> getListSubComment() {
        return listSubComment;
    }

    public void setListSubComment(List<SubCommentPostDTO> listSubComment) {
        this.listSubComment = listSubComment;
    }
    
    
    
}
