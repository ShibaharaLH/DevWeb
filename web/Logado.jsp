<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Twitter Simulator</title>
        
        <style type="text/css">
        input[type="submit"]{border: none; width: 80px; height: 25px; margin-top: 20px; border-radius: 3px; margin-right: 10px; margin-left: 10px;}
        input[type="submit"]:hover{background-color: #1E90FF; color: #FFF; cursor: pointer;}
        </style>
        
    </head>
    <body>
    
    <%
        String usuario = (String) session.getAttribute("usuario");
        
        if(usuario == null){
            response.sendRedirect("PaginaLogin.jsp");
        }else{
            out.print("Bem Vindo, "+usuario+" <br />");
        }

    %>  
        <h1> Welcome to the Twitter Simulator !</h1>
        <form>
            <input type="submit" value="Logout" name="Logout" />
        </form>
    
    <%
            
        if(request.getParameter("Logout") != null){
            response.sendRedirect("LogoutUser.jsp");
        }
    %>
    
    </body>
</html>