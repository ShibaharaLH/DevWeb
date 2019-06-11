<!DOCTYPE html>

<html>
    <head>
        <script type="text/javascript">
            function validarPassword() {
                if (document.formResetPasswordByEmail.txtNewPassword.value == "") {
                    alert("Campo senha não Informado");
                    return false;
                }
                if (document.formResetPasswordByEmail.txtConfirmNewPassword.value == "") {
                    alert("Campo confirmar senha não Informado");
                    return false;
                }
                if (document.formResetPasswordByEmail.txtNewPassword.value != document.formResetPasswordByEmail.txtConfirmNewPassword.value) {
                    alert("Senha e confirmar senha com valores diferentes");
                    return false;
                }

                document.formResetPasswordByEmail.submit();
            }
        </script>
        <title> Reset Password </title>

        <style type="text/css">
            *{font-family: 'Montserrat', cursive;}
            form{text-align: center; margin-top: 10px;}
            input[type="email"]{border: 3px solid #CCC; width: 280px; height: 28px; pudding-left: 10px; margin-top: 10px; border-radius: 5px;}
            input[type="password"]{border: 3px solid #CCC; width: 280px; height: 28px; pudding-left: 10px; margin-top: 10px; border-radius: 5px;}
            input[type="button"]{border: 10px solid #CCC; margin-top: 50px;}
            input[type="submit"]{border: none; width: 80px; height: 25px; margin-top: 20px; border-radius: 3px; margin-right: 10px; margin-left: 10px;}
            input[type="submit"]:hover{background-color: #1E90FF; color: #FFF; cursor: pointer;}
            h1{text-align: center; margin-top: 115px;}
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

        <h1> Reset Password </h1>

        <form name="formResetPasswordByEmail" action="resetPassword" method="post">
            <input type="password" placeholder=" Password" name="txtNewPassword"><br />
            <input type="password" placeholder=" Confirm Password" name="txtConfirmNewPassword"><br />
            <input type="button" value="Resetar senha" name="resetPassword" onclick="validarPassword()"/><br/>
        </form>

    </body>
</html>
