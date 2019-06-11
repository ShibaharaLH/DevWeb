<%-- 
    Document   : Login
    Created on : 31/05/2019, 15:28:51
    Author     : kono
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script type="text/javascript">
            function validarLogin() {
                if (document.formLogin.txtEmail.value == "") {
                    alert("Campo Usuário Não Informado");
                    return false;
                }
                if (document.formLogin.txtSenha.value == "") {
                    alert("Campo Senha Não Informado");
                    return false;
                }

                document.formLogin.submit();
            }
        </script>
        <title>Acessar</title>
    </head>
    <body>
        <!--    <form name="formLogin" action="Login" method="post"> -->
        <form name="formLogin" action="Login" method="post">
            <p align="center">
            <table>
                <tr><td>Usuário:</td><td><input type="text" name="txtEmail"/></td></tr>
                <tr><td>Senha:</td><td><input type="password" name="txtSenha"/></td></tr>
                <tr><td colspan="2" align="center"><input type="button" value="Entrar" onclick="validarLogin()"/></td></tr>
            </table>
            </p>
        </form>
</body>
</html>
