<html>
    <head>
        <title>Cadastrar Usuário</title>
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
                    <form class="login100-form" name="formCadastrarUsuario" action="Usuario" method="post">
                        <span class="login100-form-logo">
                            <i class="zmdi zmdi-landscape"></i>
                        </span>

                        <span class="login100-form-title p-b-34 p-t-27">
                            Cadastrar Usuário
                        </span>

                        <div class="wrap-input100" data-validate = "Enter username">
                            <input class="input100" type="text" name="txtUserName" placeholder="Username">
                            <span class="focus-input100" data-placeholder="&#xf207;"></span>
                        </div>

                        <div class="wrap-input100" data-validate = "Enter email">
                            <input class="input100" type="text" name="txtEmail" placeholder="Email">
                            <span class="focus-input100" data-placeholder="&#xf207;"></span>
                        </div>

                        <div class="wrap-input100" data-validate="Enter password">
                            <input class="input100" type="password" name="txtPassword" placeholder="Password">
                            <span class="focus-input100" data-placeholder="&#xf191;"></span>
                        </div>

                        <div class="wrap-input100" data-validate="Confirm password">
                            <input class="input100" type="password" name="txtConfirmPassword" placeholder="Confirmar senha">
                            <span class="focus-input100" data-placeholder="&#xf191;"></span>
                        </div>

                        <div class="container-login100-form-btn">
                            <input type="button" value="Create" name="Criar" class="login100-form-btn" style="background: white" onclick="validarFormUsuario()">
                        </div>
                        <div class="text-center p-t-70">
                            <a class="txt1" href="Login.jsp">
                                Voltar para área de acesso
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <footer>
            <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
            <!--<script src="js/main.js"></script>-->
            <script src="js/validarForm.js"></script>
        </footer>
    </body>
</html>