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
public class Usuario {

    private String userName;
    private String email;
    private String senha;
    private Boolean ativo; 

    public Usuario(String userName, String email, String senha, Boolean ativo) {
        this.userName = userName;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    

}
