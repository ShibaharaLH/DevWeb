<!DOCTYPE html>
<html>
    <head>
        <title> Configurações do Usuário </title>
        <script type="text/javascript">
            function validarUserName() {
                if (document.formUserName.txtChangeUserName.value == "") {
                    alert("Campo userName não Informado");
                    return false;
                }

                document.formUserName.submit();
            }
            function validarPassword() {
                if (document.formPassword.txtChangePassword.value == "") {
                    alert("Campo senha não Informado");
                    return false;
                }
                if (document.formPassword.txtConfirmChangePassword.value == "") {
                    alert("Campo confirmar senha não Informado");
                    return false;
                }
                if(document.formPassword.txtChangePassword.value != document.formPassword.txtConfirmChangePassword.value){
                    alert("Senha e confirmar senha com valores diferentes");
                    return false;
                }

                document.formPassword.submit();
            }
            function validarEmail() {
                if (document.formEmail.txtChangeEmail.value == "") {
                    alert("Campo email não Informado");
                    return false;
                }

                document.formEmail.submit();
            }
        </script>
        
        <style type="text/css">
        *{font-family: 'Montserrat', cursive;}
        form{text-align: center; margin-top: 10px;}
        input[type="text"]{text-align: center; border: 3px solid #CCC; width: 280px; height: 28px; pudding-left: 10px; margin-top: 10px; border-radius: 15px;}
        input[type="password"]{border: 3px solid #CCC; width: 280px; height: 28px; pudding-left: 10px; margin-top: 13px; border-radius: 15px;}
        input[type="email"]{border: 3px solid #CCC; width: 280px; height: 28px; pudding-left: 10px; margin-top: -5px; border-radius: 15px;}
        input[type="button"]{border: none; width: 280px; height: 25px; margin-top: 15px; margin-bottom: 20px; border-radius: 10px; margin-right: 10px; margin-left: 10px;}
        input[type="button"]:hover{background-color: #1E90FF; color: #FFF; cursor: pointer;}
        h1{text-align: center; margin-top: 115px; color: white;}
        button{background-color: #D8D8BF; margin-left: 1230px; margin-top: 10px;}
        button:hover{background-color: #1E90FF; color: #FFF; cursor: pointer;}
        body{
            background-image: url(.jpg);
            background-attachment: fixed;
            background-size: 100%;
            background-repeat: no-repeat;
            background-color: #000;
        }    
        </style>
        
    </head>
    
    <body>
       
        <h1> Configurações do Usuário </h1>
        
        <form name="formUserName" action="Usuario" method="post">
            <input type="text" placeholder=" Username" name="txtChangeUserName"/><br/>
            <input type="button" value="Alterar Usuário" name="AlterarUsuario" onclick="validarUserName()"/><br/>
        </form>
        
        <form name="formPassword" action="Usuario" method="post">
            <input type="password" placeholder=" Password" name="txtChangePassword" /><br/>
            <input type="password" placeholder=" Confirm Password" name="txtConfirmChangePassword"/><br/>
            <input type="button" value="Alterar Senha" name="AlterarSenha" onclick="validarPassword()"/><br/>
        </form>
        
        <form name="formEmail" action="Usuario" method="post">
            <input type="email" placeholder=" Email" name="txtChangeEmail" /><br/>
            <input type="button" value="Alterar Email" name="AlterarEmail" onclick="validarEmail()"/><br/>
        </form>

    </body>
</html>