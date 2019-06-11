<!DOCTYPE html>

<html>
    <head>
        <script type="text/javascript">
            function validarFormUsuario() {
                if (document.formCadastrarUsuario.txtUserName.value == "") {
                    alert("Campo userName não Informado");
                    return false;
                }
                if (document.formCadastrarUsuario.txtEmail.value == "") {
                    alert("Campo email não Informado");
                    return false;
                }
                if (document.formCadastrarUsuario.txtPassword.value == "") {
                    alert("Campo senha não Informado");
                    return false;
                }
                if (document.formCadastrarUsuario.txtConfirmPassword.value == "") {
                    alert("Campo confirmar senha não Informado");
                    return false;
                }
                if(document.formCadastrarUsuario.txtPassword.value != document.formCadastrarUsuario.txtConfirmPassword.value){
                    alert("Senha e confirmar senha com valores diferentes");
                    return false;
                }

                document.formCadastrarUsuario.submit();
            }
        </script>
        <title> Criar conta - Twitter Simulator </title>
        <style type="text/css">
        *{font-family: 'Montserrat', cursive;}
        form{text-align: center; margin-top: 20px;}
        input[type="text"]{border: 3px solid #CCC; width: 280px; height: 28px; pudding-left: 10px; margin-top: 10px; border-radius: 5px;}
        input[type="email"]{border: 3px solid #CCC; width: 280px; height: 28px; pudding-left: 10px; margin-top: 10px; border-radius: 5px;}
        input[type="password"]{border: 3px solid #CCC; width: 280px; height: 28px; pudding-left: 10px; margin-top: 10px; border-radius: 5px;}
        input[type="submit"]{border: none; width: 80px; height: 25px; margin-top: 20px; border-radius: 3px; margin-right: 10px; margin-left: 10px;}
        input[type="submit"]:hover{background-color: #1E90FF; color: #FFF; cursor: pointer;}
        h1{color: #FFF; text-align: center; margin-top: 180px;}
        body{
            background-image: url(create.jpeg);
            background-attachment: fixed;
            background-size: 100%;
            background-repeat: no-repeat;
            background-color: #000;
        } 
        </style>
        
    </head>
    <body>

        <h1> Create Account </h1>
        
        <form name="formCadastrarUsuario" action="Usuario" method="post">
            
            <input type="text" placeholder=" Name" name="txtUserName"><br />
            <input type="email" placeholder=" Email" name="txtEmail"><br />
            <input type="password" placeholder=" Password" name="txtPassword"><br />
            <input type="password" placeholder=" Confirm Password" name="txtConfirmPassword"><br />
            <input type="button" value="Create" name="Criar" onclick="validarFormUsuario()">
            <input type="button" value="Sign in" name="Entrar" />
            
        </form>
        
        <%
            
            if(request.getParameter("Entrar") != null){
                response.sendRedirect("PaginaLogin.jsp");
            }else if(request.getParameter("Criar") != null){
                
                response.sendRedirect("CreateUser.jsp");
            }
            
        %>
    </body>
</html>