/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prototipoRedeSocial.DAO;

import br.com.prototipoRedeSocial.DTO.PostCommentDTO;
import br.com.prototipoRedeSocial.DTO.PostDTO;
import br.com.prototipoRedeSocial.DTO.SubCommentPostDTO;
import br.com.prototipoRedeSocial.models.Post;
import br.com.prototipoRedeSocial.models.PostComment;
import br.com.prototipoRedeSocial.models.SubCommentPost;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kono
 */
public class PublicacaoDAO {
    
    private Connection connection;

    public PublicacaoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<Post> getPosts() throws SQLException{
        List<Post> toReturn = new ArrayList<Post>();
        String sql = "select * from Post";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            ResultSet result = stmt.executeQuery();
            while (result.next() == true) {
                toReturn.add(new Post(result.getInt("idPost"), result.getString("postValue"), result.getString("email")));
            }
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return toReturn;
    }
    
    public void inserirPost(Post post) throws SQLException {
        String sql = "insert into Post (postValue, email) values (?, ?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, post.getPostValue());
            stmt.setString(2, post.getEmail());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
        }
    }
    
    public void atualizarPost(Post post) throws SQLException{
        String sql = "update Post set postValue = ? where idPost = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, post.getPostValue());
            stmt.setInt(2, post.getIdPost());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
        } finally {
            connection.close();
        }
    }
    
    public void excluirPost(Post post) throws SQLException{
        String sql = "delete from Post where idPost = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, post.getIdPost());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    
    public void inserirPostComment(PostComment comment) throws SQLException{
        String sql = "insert into PostComment (idPost, postCommentValue, email) values (?, ?, ?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, comment.getIdPost());
            stmt.setString(2, comment.getCommentValue());
            stmt.setString(3, comment.getEmail());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    
    public void atualizarPostComment(PostComment comment) throws SQLException{
        String sql = "update PostComment set postCommentValue = ? where idPostComment = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, comment.getCommentValue());
            stmt.setInt(2, comment.getIdPostComment());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    
    public void excluirPostComment(PostComment comment) throws SQLException{
        String sql = "delete from PostComment where idPostComment = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, comment.getIdPostComment());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    
    public void inserirSubCommentPost(SubCommentPost subComment) throws SQLException{
        String sql = "insert into SubCommentPost (idPostComment, idPost, subCommentPostValue, email) values (?, ?, ?, ?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, subComment.getIdCommentPost());
            stmt.setInt(2, subComment.getIdPost());
            stmt.setString(3, subComment.getSubCommentValue());
            stmt.setString(4, subComment.getEmail());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    
     public void atualizarSubCommentPost(SubCommentPost subComment) throws SQLException{
        String sql = "update SubCommentPost set subCommentPostValue = ? where idSubCommentPost = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, subComment.getSubCommentValue());
            stmt.setInt(2, subComment.getIdCommentPost());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    
    public void excluirSubCommentPost(SubCommentPost subComment) throws SQLException{
        String sql = "delete from SubCommentPost where idSubCommentPost = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, subComment.getIdSubCommentPost());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    
    public PostDTO postDetails(Post post) throws SQLException{
        List<PostCommentDTO> listPostComment = new ArrayList<PostCommentDTO>();
        String sql = "select * from PostComment where idPost = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, post.getIdPost());

            ResultSet result = stmt.executeQuery();
            while (result.next() == true) {
                listPostComment.add(new PostCommentDTO(result.getInt("idPostComment"), result.getString("postCommentValue"),
                result.getString("email"), getListSubCommentPost(result.getInt("idPostComment"))));
            }
            result.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        PostDTO postDetails = new PostDTO(post.getIdPost(), post.getPostValue(), post.getEmail(), listPostComment);
        return postDetails;
    }
    
    private List<SubCommentPostDTO> getListSubCommentPost(int idCommentPost) throws SQLException{
        List<SubCommentPostDTO> toReturn = null;
        String sql = "select * from SubCommentPost where idPostComment = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, idCommentPost);

            ResultSet result = stmt.executeQuery();
            while (result.next() == true) {
                toReturn.add(new SubCommentPostDTO(result.getString("subCommentPostValue"), result.getString("email")));
            }
            result.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return toReturn;
    }
    
}
