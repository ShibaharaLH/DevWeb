/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prototipoRedeSocial.DTO;

/**
 *
 * @author kono
 */
public class SubCommentPostDTO {
    
    private String subCommentValue;
    private String email;

    public SubCommentPostDTO(String subCommentValue, String email) {
        this.subCommentValue = subCommentValue;
        this.email = email;
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
