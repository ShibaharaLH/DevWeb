<html>
    <head>
        <title>Configurar Usuário</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">

    </head>
    <body style="background-color: black">

        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <span class="login100-form-title p-b-34 p-t-27">
                        Configurar Usuário
                    </span>
                    <span class="login100-form-logo">
                        <i class="zmdi zmdi-landscape"></i>
                    </span><br>
                    <form class="login100-form" name="formUserName" action="Usuario" method="post">
                        <div class="wrap-input100" data-validate = "Enter username">
                            <input class="input100" type="text" name="txtChangeUserName" placeholder="Username">
                            <span class="focus-input100" data-placeholder="&#xf207;"></span>
                        </div>
                        <div class="container-login100-form-btn">
                            <input type="button" value="Alterar UserName" name="AlterarUserName" class="login100-form-btn" style="background: white" onclick="validarUserNameAlterarUsuario()">
                        </div>
                    </form><br>
                    <form class="login100-form" name="formEmail" action="Usuario" method="post">
                        <div class="wrap-input100" data-validate = "Enter email">
                            <input class="input100" type="text" name="txtChangeEmail" placeholder="Email">
                            <span class="focus-input100" data-placeholder="&#xf207;"></span>
                        </div>
                        <div class="container-login100-form-btn">
                            <input type="button" value="Alterar Email" name="AlterarEmail" class="login100-form-btn" style="background: white" onclick="validarEmailAlterarUsuario()">
                        </div>
                    </form><br>
                    <form class="login100-form"  name="formPassword" action="Usuario" method="post">
                        <div class="wrap-input100" data-validate="Enter password">
                            <input class="input100" type="password" name="txtChangePassword" placeholder="Password">
                            <span class="focus-input100" data-placeholder="&#xf191;"></span>
                        </div>

                        <div class="wrap-input100" data-validate="Confirm password">
                            <input class="input100" type="password" name="txtConfirmChangePassword" placeholder="Confirmar senha">
                            <span class="focus-input100" data-placeholder="&#xf191;"></span>
                        </div>
                        <div class="container-login100-form-btn">
                            <input type="button" value="Alterar senha" name="AlterarSenha" class="login100-form-btn" style="background: white" onclick="validarPasswordAlterarUsuario()">
                        </div>
                        <div class="text-center p-t-70">
                            <a class="txt1" href="ExcluiUser.jsp">
                                Excluir usuario
                            </a><br>
                            <a class="txt1" href="DesativaUser.jsp">
                                Desativar usuario
                            </a><br>
                            <a class="txt1" href="Home.jsp">
                                Voltar para Home
                            </a><br>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <footer>
            <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
            <!--<script src="js/main.js"></script>-->
            <script src="js/validarForm.js"></script>
            <script src="js/validarForm.js"></script>
        </footer>
    </body>
</html>