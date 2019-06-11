<!DOCTYPE html>

<html>
    <head>
        <script type="text/javascript">
            function validarEmail() {
                if (document.formEmailActiveUser.txtEmailActiveUser.value == "") {
                    alert("Campo email não Informado");
                    return false;
                }

                document.formEmailActiveUser.submit();
            }
        </script>
        <title> Active Account - Twitter Simulator </title>

        <style type="text/css">
        *{font-family: 'Montserrat', cursive;}
        form{text-align: center; margin-top: 20px;}
        input[type="text"]{border: 3px solid #CCC; width: 280px; height: 28px; pudding-left: 10px; margin-top: 10px; border-radius: 5px;}
        input[type="email"]{border: 3px solid #CCC; width: 280px; height: 28px; pudding-left: 10px; margin-top: 10px; border-radius: 5px;}
        input[type="password"]{border: 3px solid #CCC; width: 280px; height: 28px; pudding-left: 10px; margin-top: 10px; border-radius: 5px;}
        input[type="submit"]{border: none; width: 80px; height: 25px; margin-top: 20px; border-radius: 3px; margin-right: 10px; margin-left: 10px;}
        input[type="submit"]:hover{background-color: #1E90FF; color: #FFF; cursor: pointer;}
        h1{color: #FF0000; text-align: center; margin-top: 135px;}
        button{border: none; width: 80px; height: 25px; margin-top: 10px; border-radius: 3px; margin-right: 1230px; margin-left: 10px;}
        button:hover{background-color: #1E90FF; color: #FFF; cursor: pointer;}
        body{
            background-image: url(active.jpeg);
            background-attachment: fixed;
            background-size: 100%;
            background-repeat: no-repeat;
            background-color: #000;
        } 
        </style>
        
    </head>
    <body>
        
        <form method="post">
            <button class="btn btn-primary btn-sm" name="Home"> Home </button>
        </form>

        <h1> Active Account </h1>
        
        <form name="formEmailActiveUser" action="Usuario" method="get">
            <input type="email" placeholder=" email" name="txtEmailActiveUser"><br />
            <input type="button" value="Enviar email para ativar usuário" name="emailActiveUser" onclick="validarEmail()"/><br/>
        </form>
        
    </body>
</html>