package br.com.prototipoRedeSocial.controllers;

import br.com.prototipoRedeSocial.DAO.UsuarioDAO;
import br.com.prototipoRedeSocial.DTO.UsuarioDTO;
import br.com.prototipoRedeSocial.connector.ConnectorDataBase;
import br.com.prototipoRedeSocial.service.PlainTextEmailSender;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
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
@WebServlet(name = "NewPasswordController", urlPatterns = {"/resetPassword"})
public class NewPasswordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processGetRequest(request, response);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
            requestDispatcher.forward(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(NewPasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            proccessPostRequest(request, response);
        } catch (MessagingException | SQLException ex) {
            Logger.getLogger(NewPasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processGetRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException {
        String mailTo = request.getParameter("txtEmailResetPassword");
        enviaEmailResetarSenha(request, mailTo);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
        requestDispatcher.forward(request, response);
    }

    private void enviaEmailResetarSenha(HttpServletRequest request, String email) {
        // outgoing message information
        HttpSession session = request.getSession();
        session.setAttribute("emailResetPassword", email);
        String subject = "Email para resetar senha";
        String message = "Para resetar sua senha entre no seguinte link: http://localhost:8080/PrototipoRedeSocial/newPassword.jsp";

        PlainTextEmailSender mailer = new PlainTextEmailSender();

        try {
            mailer.sendPlainTextEmail(email, subject, message);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
            ex.printStackTrace();
        }
    }

    protected void proccessPostRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException, SQLException {
        String newPassword = request.getParameter("txtNewPassword");
        HttpSession session = request.getSession();
        String email = session.getAttribute("emailResetPassword").toString();
        UsuarioDTO usuarioRequest = new UsuarioDTO("", email, "", newPassword);
        UsuarioDAO usuarioDAO = new UsuarioDAO(ConnectorDataBase.getConexao());
        usuarioDAO.alterarPassword(usuarioRequest);
    }

}
