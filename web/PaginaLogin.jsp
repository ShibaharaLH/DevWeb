<!DOCTYPE html>

<html>
    <head>
        <title> Login - Twitter Simulator </title>
        <script type="text/javascript">
            function validarLogin() {
                if (document.formLogin.txtUsuario.value == "") {
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
        <style type="text/css">
        *{font-family: 'Montserrat', cursive;}
        form{text-align: center; margin-top: 10px;}
        input[type="email"]{border: 3px solid #CCC; width: 280px; height: 28px; pudding-left: 10px; margin-top: 10px; border-radius: 5px;}
        input[type="password"]{border: 3px solid #CCC; width: 280px; height: 28px; pudding-left: 10px; margin-top: 10px; border-radius: 5px;}
        input[type="button"]{border: 10px solid #CCC; margin-top: 50px;}
        input[type="submit"]{border: none; width: 80px; height: 25px; margin-top: 10px; border-radius: 3px; margin-right: 10px; margin-left: 10px;}
        input[type="submit"]:hover{background-color: #1E90FF; color: #FFF; cursor: pointer;}
        h1{text-align: center; margin-top: 115px;}
        button{background-color: #D8D8BF; margin-left: 1230px; margin-top: 10px;}
        button:hover{background-color: #1E90FF; color: #FFF; cursor: pointer;}
        body{
            background-image: url(gatinho.jpeg);
            background-attachment: fixed;
            background-size: 100%;
            background-repeat: no-repeat;
            background-color: #000;
        }    
        </style>

    </head>
    
    <body>
        
        <form>
            <button class="btn btn-primary btn-sm" name='newUser'> Create Account </button>
        </form>
       
        <h1> Sign in </h1>
        
        <form action="PaginaLogin.jsp" method="post">
            <input type="email" placeholder=" Email" name="usuario"><br />
            <input type="password" placeholder=" Password" name="senha"><br />
            <input type="submit" value="Entrar" name="Login" />
        </form>
        
        <form method="post">
            
            <input type="submit" value="Reset" name="Reset" />
            <input type="submit" value="Active" name="Active" /> 
        </form>
        
        <%
            
            String usuario  = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            String novoUsuario = request.getParameter("newUser");
            
            if(request.getParameter("Login") != null){
                
                if(usuario!=null && senha!=null && !usuario.isEmpty() && !senha.isEmpty()){
                    session.setAttribute("usuario", usuario);
                    //session.setAttribute("senha", senha);
                    response.sendRedirect("Logado.jsp");
                }
            }else if(novoUsuario != null){
                response.sendRedirect("CreateUser.jsp");
            }else if(request.getParameter("Reset") != null){
                response.sendRedirect("resetPassword.jsp");
            }else if(request.getParameter("Active") != null){
                response.sendRedirect("ActiveUser.jsp");
            }

        %>
        
    </body>
</html>