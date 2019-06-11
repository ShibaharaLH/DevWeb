<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function validarPassword() {
                if (document.formDeleteUser.txtDeletePassword.value == "") {
                    alert("Campo senha não Informado");
                    return false;
                }
                if (document.formDeleteUser.txtConfirmDeletePassword.value == "") {
                    alert("Campo confirmar senha não Informado");
                    return false;
                }
                if(document.formDeleteUser.txtDeletePassword.value != document.formDeleteUser.txtConfirmDeletePassword.value){
                    alert("Senha e confirmar senha com valores diferentes");
                    return false;
                }

                document.formDeleteUser.submit();
            }
        </script>
        <title> Excluir Usuário </title>
        
        <style type="text/css">
        *{font-family: 'Montserrat', cursive;}
        form{text-align: center; margin-top: 10px;}
        input[type="text"]{text-align: center; border: 3px solid #CCC; width: 280px; height: 28px; pudding-left: 10px; margin-top: 10px; border-radius: 15px;}
        input[type="password"]{text-align: center; border: 3px solid #CCC; width: 280px; height: 28px; pudding-left: 10px; margin-top: 13px; border-radius: 15px;}
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
       
        <h1> Excluir Usuário </h1>
        
        <form name="formDeleteUser" action="Usuario" method="post">
            <input type="password" placeholder=" Password" name="txtDeletePassword" /><br/>
            <input type="password" placeholder=" Confirm Password" name="txtConfirmDeletePassword"/><br/>
            <input type="button" value="Excluir" name="ExcluirUsuario" onclick="validarPassword()"/><br/>
        </form>
        
    </body>
</html>