/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prototipoRedeSocial.DAO;

import br.com.prototipoRedeSocial.DTO.UsuarioLoginDTO;
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

    public Usuario login(UsuarioLoginDTO usuarioRequest) throws SQLException {
        Usuario usuarioResponse = new Usuario("", "", false);
        String sql = "select * from Usuario where email = ? and senha = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, usuarioRequest.getEmail());
            stmt.setString(2, usuarioRequest.getSenha());

            ResultSet result = stmt.executeQuery();
            if(result.next() == true){
                usuarioResponse.setEmail(result.getString("email"));
                usuarioResponse.setSenha(result.getString("senha"));
                if(result.getInt("ativo") == 1){
                    usuarioResponse.setAtivo(true);
                }
            }
            result.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
            connection = null;
        }
        return usuarioResponse;
    }
}
