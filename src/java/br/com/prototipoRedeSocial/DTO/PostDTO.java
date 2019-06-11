package br.com.prototipoRedeSocial.DTO;

import br.com.prototipoRedeSocial.models.PostComment;
import java.util.List;

/**
 *
 * @author kono
 */
public class PostDTO {

    private int idPost;
    private String postValue;
    private String email;
    private List<PostCommentDTO> listPostComment;

    public PostDTO(int idPost, String postValue, String email, List<PostCommentDTO> listPostComment) {
        this.idPost = idPost;
        this.postValue = postValue;
        this.email = email;
        this.listPostComment = listPostComment;
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

    public List<PostCommentDTO> getListPostComment() {
        return listPostComment;
    }

    public void setListPostComment(List<PostCommentDTO> listPostComment) {
        this.listPostComment = listPostComment;
    }

    
}
