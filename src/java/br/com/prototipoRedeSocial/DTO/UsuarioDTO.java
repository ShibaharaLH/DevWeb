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
public class UsuarioDTO {
    
    private String userName;
    private String email;
    private String newEmail;
    private String senha;

    public UsuarioDTO(String userName, String email, String newEmail, String senha) {
        this.userName = userName;
        this.email = email;
        this.newEmail = newEmail;
        this.senha = senha;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
