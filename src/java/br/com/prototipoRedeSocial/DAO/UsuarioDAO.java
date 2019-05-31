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
        Usuario usuarioResponse = new Usuario("", "", false);
        String sql = "select * from Usuario where email = ? and senha = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, usuarioRequest.getEmail());
            stmt.setString(2, usuarioRequest.getSenha());

            ResultSet result = stmt.executeQuery();
            if (result.next() == true) {
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
    
    public boolean verificaUsuarioCadastrado(UsuarioDTO usuarioRequest) throws SQLException{
        boolean toReturn = false;
        String sql = "select * from Usuario where email = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, usuarioRequest.getEmail());

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
        Usuario usuario = new Usuario(usuarioRequest.getEmail(), usuarioRequest.getSenha(), true);
        String sql = "insert into Usuario(email, senha, ativo) values(?, ?, 1)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
