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
import java.io.PrintWriter;
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
@WebServlet(name = "CadastrarUsuarioController", urlPatterns = {"/Cadastrar"})
public class CadastrarUsuarioController extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        cadastrarUsuario(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Home.jsp");
        requestDispatcher.forward(request, response);
    }
     
     private void cadastrarUsuario(HttpServletRequest request) throws ServletException, SQLException {
        String nomeUsuario = request.getParameter("txtUsuario");
        String senha = request.getParameter("txtSenha");
        UsuarioDTO usuarioRequest = new UsuarioDTO(nomeUsuario, senha);
        UsuarioDAO usuarioDAO = new UsuarioDAO(ConnectorDataBase.getConexao());
        if(usuarioDAO.verificaUsuarioCadastrado(usuarioRequest) == false){
            usuarioDAO.cadastrarUsuario(usuarioRequest);
        }else{
            throw new ServletException("Usuário já cadastrado");
        }
    }
}
