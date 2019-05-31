<%-- 
    Document   : Cadastrar
    Created on : 31/05/2019, 16:08:47
    Author     : kono
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastrar Usuario</title>
    </head>
    <body>
        <h2>Cadastrar Usuario</h2>
        <table>
            <form name="frmCadastrarUsuario" action="Cadastrar" method="post">

                <tr> 
                    <td>Email.:</td><td><input type="text" name="txtUsuario"></td>
                    <td>Senha.:</td><td><input type="password" name="txtSenha"></td>

                    <td colspan="2"><input type="submit" value="cadastrar"/></td>      

            </form>

        </table>

    </body>
</html>