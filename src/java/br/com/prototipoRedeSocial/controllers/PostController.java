/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prototipoRedeSocial.controllers;

import br.com.prototipoRedeSocial.DAO.PublicacaoDAO;
import br.com.prototipoRedeSocial.connector.ConnectorDataBase;
import br.com.prototipoRedeSocial.models.Post;
import br.com.prototipoRedeSocial.models.PostComment;
import java.io.IOException;
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
        if (session.getAttribute("emailUsuarioAutenticado") == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
            requestDispatcher.forward(request, response);
        } else {
            if (request.getParameter("txtAreaPost") != null) {
                String newPostValue = request.getParameter("txtAreaPost");
                String newPostEmail = session.getAttribute("emailUsuarioAutenticado").toString();
                Post newPost = new Post(0, newPostValue, newPostEmail);
                publicacaoDAO.inserirPost(newPost);
            }
            if (request.getParameter("hiddenPostIDAlterar") != null) {
                int idPost = Integer.parseInt(request.getParameter("hiddenPostIDAlterar"));
                session.setAttribute("idPost", idPost);
                session.setAttribute("postEmail", request.getParameter("hiddenPostEmailAlterar"));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("AlterarPost.jsp");
                requestDispatcher.forward(request, response);
            }
            if (request.getParameter("txtEditarPost") != null) {
                String newValuePost = request.getParameter("txtEditarPost");
                int idPost = Integer.parseInt(session.getAttribute("idPost").toString());
                String user1 =session.getAttribute("emailUsuarioAutenticado").toString();
                if (user1.equals(session.getAttribute("postEmail").toString())) {
                    publicacaoDAO.atualizarPost(new Post(idPost, newValuePost, ""));
                }
            }
            if (request.getParameter("hiddenPostIDExcluir") != null) {
                int idPost = Integer.parseInt(request.getParameter("hiddenPostIDExcluir"));
                String user1 = session.getAttribute("emailUsuarioAutenticado").toString();
                String user2 = request.getParameter("hiddenPostEmailExcluir");
                if (user1.equals(user2)) {
                    publicacaoDAO.excluirPost(idPost);
                }
            }
            List<Post> postList = publicacaoDAO.getPosts();
            session.setAttribute("postList", postList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Home.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    protected void processGetRequest(HttpServletRequest request, HttpServletResponse response, PublicacaoDAO publicacaoDAO)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        if (session.getAttribute("emailUsuarioAutenticado") == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
            requestDispatcher.forward(request, response);
        } else {
            List<PostComment> postDetails = publicacaoDAO.getPostComment(Integer.parseInt(request.getParameter("hiddenPostID")));
            session.setAttribute("idPostDetails", Integer.parseInt(request.getParameter("hiddenPostID")));
            session.setAttribute("postDetails", postDetails);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("PostDetails.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
