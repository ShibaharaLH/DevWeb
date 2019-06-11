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
@WebServlet(name = "UsuarioController", urlPatterns = {"/Usuario"})
public class UsuarioController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(ConnectorDataBase.getConexao());
            processPostRequest(request, response, usuarioDAO);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(ConnectorDataBase.getConexao());
            proccessGetRequest(request, response, usuarioDAO);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response, UsuarioDAO usuarioDAO)
            throws ServletException, IOException, SQLException {
        if (request.getParameter("txtChangeUserName") != null || request.getParameter("txtChangePassword") != null
                || request.getParameter("txtChangeEmail") != null) {
            alteraUsuario(request, usuarioDAO);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("configUser.jsp");
            requestDispatcher.forward(request, response);
        } else if (request.getParameter("txtDisablePassword") != null) {
            desativaUsuario(request, usuarioDAO);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
            requestDispatcher.forward(request, response);
        } else if (request.getParameter("txtDeletePassword") != null) {
            excluiUsuario(request, usuarioDAO);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
            requestDispatcher.forward(request, response);
        } else if(request.getParameter("txtUserName") != null && request.getParameter("txtEmail") != null
                && request.getParameter("txtPassword") != null){
            cadastrarUsuario(request, usuarioDAO);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    protected void proccessGetRequest(HttpServletRequest request, HttpServletResponse response, UsuarioDAO usuarioDAO) throws ServletException, IOException, SQLException {
        String email = request.getParameter("txtEmailActiveUser");
        UsuarioDTO usuarioRequest = new UsuarioDTO("", email, "", "");
        if (usuarioDAO.verificaUsuarioAtivo(usuarioRequest)) {
            throw new ServletException("Usuario já ativo");
        } else {
            enviaEmailAtivarUsuario(request, email);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void cadastrarUsuario(HttpServletRequest request, UsuarioDAO usuarioDAO) throws ServletException, SQLException {
        String userName = request.getParameter("txtUserName");
        String email = request.getParameter("txtEmail");
        String password = request.getParameter("txtPassword");
        UsuarioDTO usuarioRequest = new UsuarioDTO(userName, email, null, password);
        if (usuarioDAO.verificaEmailCadastrado(usuarioRequest) == false) {
            if (usuarioDAO.verificaUserNameCadastrado(usuarioRequest) == false) {
                usuarioDAO.cadastrarUsuario(usuarioRequest);
                enviaEmailAtivarUsuario(request, email);
            } else {
                throw new ServletException("UserName já cadastrado");
            }
        } else {
            throw new ServletException("Email já cadastrado");
        }
    }

    private void enviaEmailAtivarUsuario(HttpServletRequest request, String email) {
        // outgoing message information
        HttpSession session = request.getSession();
        session.setAttribute("emailActiveUser", email);
        String message = "Para ativar seu usuário entre no seguinte link: http://localhost:8080/PrototipoRedeSocial/newPassword.jsp";
        String subject = "Email para ativar usuário";
        PlainTextEmailSender mailer = new PlainTextEmailSender();

        try {
            mailer.sendPlainTextEmail(email, subject, message);
            System.out.println("Email sent.");
        } catch (MessagingException ex) {
            System.out.println("Failed to sent email.");
        }
    }

    private void alteraUsuario(HttpServletRequest request, UsuarioDAO usuarioDAO) throws ServletException, SQLException {
        String newUserName = request.getParameter("txtChangeUserName");
        String newEmail = request.getParameter("txtChangeEmail");
        String newPassword = request.getParameter("txtChangePassword");
        HttpSession session = request.getSession();
        String email = session.getAttribute("emailUsuarioAutenticado").toString();
        UsuarioDTO usuarioRequest = new UsuarioDTO(newUserName, email, newEmail, newPassword);
        if (newUserName != null) {
            usuarioDAO.alterarUserName(usuarioRequest);
        } else if (newEmail != null) {
            usuarioDAO.alterarEmail(usuarioRequest);
        } else if (newPassword != null) {
            usuarioDAO.alterarPassword(usuarioRequest);
        }
    }
    
    private void ativaUsuario(HttpServletRequest request, UsuarioDAO usuarioDAO) throws ServletException, SQLException {
        HttpSession session = request.getSession();
        String email = session.getAttribute("emailActiveUser").toString();
        UsuarioDTO usuarioRequest = new UsuarioDTO("", email, "", "");
        usuarioDAO.ativarUsuario(usuarioRequest);
    }
        

    private void desativaUsuario(HttpServletRequest request, UsuarioDAO usuarioDAO) throws ServletException, SQLException {
        HttpSession session = request.getSession();
        String email = session.getAttribute("emailUsuarioAutenticado").toString();
        session.invalidate();
        UsuarioDTO usuarioRequest = new UsuarioDTO("", email, "", "");
        usuarioDAO.desativarUsuario(usuarioRequest);
    }

    private void excluiUsuario(HttpServletRequest request, UsuarioDAO usuarioDAO) throws ServletException, SQLException {
        HttpSession session = request.getSession();
        String email = session.getAttribute("emailUsuarioAutenticado").toString();
        session.invalidate();
        UsuarioDTO usuarioRequest = new UsuarioDTO("", email, "", "");
        usuarioDAO.excluiUsuario(usuarioRequest);
    }
}