/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prototipoRedeSocial.controllers;

import br.com.prototipoRedeSocial.DAO.PublicacaoDAO;
import br.com.prototipoRedeSocial.connector.ConnectorDataBase;
import br.com.prototipoRedeSocial.models.Post;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "PostController", urlPatterns = {"/Post"})
public class PostController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PublicacaoDAO publicacaoDAO = new PublicacaoDAO(ConnectorDataBase.getConexao());
            processPostRequest(request, response, publicacaoDAO);
        } catch (SQLException ex) {
            Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PublicacaoDAO publicacaoDAO = new PublicacaoDAO(ConnectorDataBase.getConexao());
            processGetRequest(request, response, publicacaoDAO);
        } catch (SQLException ex) {
            Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response, PublicacaoDAO publicacaoDAO)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        if (request.getParameter("txtAreaPost") != null) {
            String newPostValue = request.getParameter("txtAreaPost");
            String newPostEmail = session.getAttribute("emailUsuarioAutenticado").toString();
            Post newPost = new Post(0, newPostValue, newPostEmail);
            publicacaoDAO.inserirPost(newPost);
        }
        List<Post> postList = publicacaoDAO.getPosts();
        session.setAttribute("postList", postList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Home.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void processGetRequest(HttpServletRequest request, HttpServletResponse response, PublicacaoDAO publicacaoDAO)
            throws ServletException, IOException, SQLException {
        System.out.println("postId " + request.getParameter("hiddenPostID"));
        System.out.println("email " + request.getParameter("hiddenPostEmail"));
        System.out.println("value " + request.getParameter("hiddenPostValue"));
    }
}
