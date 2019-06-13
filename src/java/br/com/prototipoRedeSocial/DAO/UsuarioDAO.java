/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prototipoRedeSocial.DAO;

import br.com.prototipoRedeSocial.DTO.UsuarioDTO;
import br.com.prototipoRedeSocial.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kono
 */
public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public Usuario login(UsuarioDTO usuarioRequest) throws SQLException {
        Usuario usuarioResponse = new Usuario("", "", "", false);
        String sql = "select * from Usuario where email = ? and senha = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, usuarioRequest.getEmail());
            stmt.setString(2, usuarioRequest.getSenha());

            ResultSet result = stmt.executeQuery();
            if (result.next() == true) {
                usuarioResponse.setUserName(result.getString("userName"));
                usuarioResponse.setEmail(result.getString("email"));
                usuarioResponse.setSenha(result.getString("senha"));
                if (result.getInt("ativo") == 1) {
                    usuarioResponse.setAtivo(true);
                }
            }
            result.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return usuarioResponse;
    }
    
    public boolean verificaUsuarioAtivo(UsuarioDTO usuarioRequest) throws SQLException{
        boolean toReturn = false;
        String sql = "select * from Usuario where email = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, usuarioRequest.getEmail());

            ResultSet result = stmt.executeQuery();
            if (result.next() == true) {
                if (result.getInt("ativo") == 1) {
                    toReturn = true;
                }
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
    
    public boolean verificaEmailCadastrado(String email) throws SQLException{
        boolean toReturn = false;
        String sql = "select * from Usuario where email = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, email);

            ResultSet result = stmt.executeQuery();
            if (result.next() == true) {
                toReturn = true;
            }
            result.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toReturn;
    }
    
    public boolean verificaUserNameCadastrado(UsuarioDTO usuarioRequest) throws SQLException{
        boolean toReturn = false;
        String sql = "select * from Usuario where userName = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, usuarioRequest.getUserName());

            ResultSet result = stmt.executeQuery();
            if (result.next() == true) {
                toReturn = true;
            }
            result.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toReturn;
    }

    public void cadastrarUsuario(UsuarioDTO usuarioRequest) throws SQLException {
        Usuario usuario = new Usuario(usuarioRequest.getUserName(), usuarioRequest.getEmail(), usuarioRequest.getSenha(), false);
        String sql = "insert into Usuario(userName, email, senha, ativo) values(?, ?, ?, 0)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, usuario.getUserName());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    
    public void excluiUsuario(UsuarioDTO usuarioRequest) throws SQLException{
        String sql = "delete from Usuario where email = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, usuarioRequest.getEmail());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    
    public void ativarUsuario(UsuarioDTO usuarioRequest) throws SQLException{
        String sql = "update Usuario set ativo = 1 where email = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, usuarioRequest.getEmail());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    
    public void desativarUsuario(UsuarioDTO usuarioRequest) throws SQLException{
        String sql = "update Usuario set ativo = 0 where email = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, usuarioRequest.getEmail());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    
    public void alterarPassword(UsuarioDTO usuarioRequest) throws SQLException{
        String sql = "update Usuario set senha = ? where email = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, usuarioRequest.getSenha());
            stmt.setString(2, usuarioRequest.getEmail());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    
    public void alterarUserName(UsuarioDTO usuarioRequest) throws SQLException{
        String sql = "update Usuario set userName = ? where email = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, usuarioRequest.getUserName());
            stmt.setString(2, usuarioRequest.getEmail());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    
    public void alterarEmail(UsuarioDTO usuarioRequest) throws SQLException{
        String sql = "update Usuario set email = ? where email = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, usuarioRequest.getNewEmail());
            stmt.setString(2, usuarioRequest.getEmail());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
