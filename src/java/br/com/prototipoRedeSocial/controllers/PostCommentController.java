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
@WebServlet(name = "PostCommentController", urlPatterns = {"/PostComment"})
public class PostCommentController extends HttpServlet {

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

    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response, PublicacaoDAO publicacaoDAO)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        if (session.getAttribute("emailUsuarioAutenticado") == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
            requestDispatcher.forward(request, response);
        } else {
            if (request.getParameter("txtAreaPostComment") != null) {
                String newPostValue = request.getParameter("txtAreaPostComment");
                String newPostEmail = session.getAttribute("emailUsuarioAutenticado").toString();
                int idPost = Integer.parseInt(session.getAttribute("idPostDetails").toString());
                PostComment newPostComment = new PostComment(0, idPost, newPostValue, newPostEmail);
                publicacaoDAO.inserirPostComment(newPostComment);
            }
            if (request.getParameter("hiddenPostCommentIDAlterar") != null) {
                int idPostComment = Integer.parseInt(request.getParameter("hiddenPostCommentIDAlterar"));
                session.setAttribute("idPostComment", idPostComment);
                session.setAttribute("postCommentEmail", request.getParameter("hiddenPostCommentEmailAlterar"));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("AlterarPostComment.jsp");
                requestDispatcher.forward(request, response);
            }
            if (request.getParameter("txtEditarPostComment") != null) {
                String newValuePost = request.getParameter("txtEditarPostComment");
                int idPostComment = Integer.parseInt(session.getAttribute("idPostComment").toString());
                String user1 =session.getAttribute("emailUsuarioAutenticado").toString();
                if (user1.equals(session.getAttribute("postCommentEmail").toString())) {
                    publicacaoDAO.atualizarPostComment(new PostComment(idPostComment, 0, newValuePost, ""));
                }
            }
            if (request.getParameter("hiddenPostCommentIDExcluir") != null) {
                int idPostComment = Integer.parseInt(request.getParameter("hiddenPostCommentIDExcluir"));
                String user1 = session.getAttribute("emailUsuarioAutenticado").toString();
                String user2 = request.getParameter("hiddenPostCommentEmailExcluir");
                if (user1.equals(user2)) {
                    publicacaoDAO.excluirPostComment(idPostComment);
                }
            }
            List<PostComment> postCommentList = publicacaoDAO.getPostComment(Integer.parseInt(session.getAttribute("idPostDetails").toString()));
            session.setAttribute("postDetails", postCommentList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("PostDetails.jsp");
            requestDispatcher.forward(request, response);
        }
    }

}
