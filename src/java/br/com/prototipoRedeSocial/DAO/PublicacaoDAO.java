/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prototipoRedeSocial.DAO;

import br.com.prototipoRedeSocial.models.Post;
import br.com.prototipoRedeSocial.models.PostComment;
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
    
    public List<PostComment> getPostComment(Post post) throws SQLException{
        List<PostComment> toReturn = new ArrayList<PostComment>();
        String sql = "select * from PostComment where idPost = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, post.getIdPost());
            
            ResultSet result = stmt.executeQuery();
            while (result.next() == true) {
                toReturn.add(new PostComment(result.getInt("idPostComment"), result.getInt("idPost"), 
                        result.getString("postCommentValue"), result.getString("email")));
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
    
}
