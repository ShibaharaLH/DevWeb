package br.com.prototipoRedeSocial.models;

/**
 *
 * @author kono
 */
public class Post {

    private int idPost;
    private String postValue;
    private String email;

    public Post(int idPost, String postValue, String email) {
        this.idPost = idPost;
        this.postValue = postValue;
        this.email = email;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getPostValue() {
        return postValue;
    }

    public void setPostValue(String postValue) {
        this.postValue = postValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
