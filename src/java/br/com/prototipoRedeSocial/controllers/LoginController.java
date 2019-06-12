/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prototipoRedeSocial.controllers;

import br.com.prototipoRedeSocial.DAO.UsuarioDAO;
import br.com.prototipoRedeSocial.DTO.UsuarioDTO;
import br.com.prototipoRedeSocial.connector.ConnectorDataBase;
import br.com.prototipoRedeSocial.models.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kono
 */
@WebServlet(name = "LoginController", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException, SQLException {
        validaDadosRecebidos(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Post");
        requestDispatcher.forward(request, response);
    }

    private void validaDadosRecebidos(HttpServletRequest request) throws ServletException, SQLException {
        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");
        UsuarioDTO usuarioLoginRequest = new UsuarioDTO("", email, null, senha);
        UsuarioDAO usuarioDAO = new UsuarioDAO(ConnectorDataBase.getConexao());
        Usuario usuarioResponse = usuarioDAO.login(usuarioLoginRequest);
        if (!usuarioResponse.getEmail().equals("")) {
            if (usuarioResponse.getAtivo() == false) {
                throw new ServletException("Usuario desativado");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("emailUsuarioAutenticado", usuarioResponse.getEmail());
                session.setAttribute("userNameUsuarioAutenticado", usuarioResponse.getUserName());
            }
        } else {
            throw new ServletException("Login ou Senha Inválida");
        }
    }
}
