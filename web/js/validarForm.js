function validarFormUsuario() {
    var formValid = true;
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
    if (document.formCadastrarUsuario.txtPassword.value != document.formCadastrarUsuario.txtConfirmPassword.value) {
        alert("Senha e confirmar senha com valores diferentes");
        return false;
    }
    document.formCadastrarUsuario.submit();
}

function validarPasswordAtivarUsuario() {
    if (document.formActiveUserByEmail.txtPasswordActive.value == "") {
        alert("Campo senha não Informado");
        return false;
    }
    if (document.formActiveUserByEmail.txtConfirmPasswordActive.value == "") {
        alert("Campo confirmar senha não Informado");
        return false;
    }
    if (document.formActiveUserByEmail.txtPasswordActive.value != document.formActiveUserByEmail.txtConfirmPasswordActive.value) {
        alert("Senha e confirmar senha com valores diferentes");
        return false;
    }

    document.formActiveUserByEmail.submit();
}

function validarPasswordDesativarUsuario() {
    if (document.formDisableUser.txtDisablePassword.value == "") {
        alert("Campo senha não Informado");
        return false;
    }
    if (document.formDisableUser.txtConfirmDisablePassword.value == "") {
        alert("Campo confirmar senha não Informado");
        return false;
    }
    if (document.formDisableUser.txtDisablePassword.value != document.formDisableUser.txtConfirmDisablePassword.value) {
        alert("Senha e confirmar senha com valores diferentes");
        return false;
    }

    document.formDisableUser.submit();
}

function validarPasswordExcluirUsuario() {
    if (document.formDeleteUser.txtDeletePassword.value == "") {
        alert("Campo senha não Informado");
        return false;
    }
    if (document.formDeleteUser.txtConfirmDeletePassword.value == "") {
        alert("Campo confirmar senha não Informado");
        return false;
    }
    if (document.formDeleteUser.txtDeletePassword.value != document.formDeleteUser.txtConfirmDeletePassword.value) {
        alert("Senha e confirmar senha com valores diferentes");
        return false;
    }

    document.formDeleteUser.submit();
}

function validarPasswordAlterarSenha() {
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

function validarUserNameAlterarUsuario() {
    if (document.formUserName.txtChangeUserName.value == "") {
        alert("Campo userName não Informado");
        return false;
    }

    document.formUserName.submit();
}
function validarPasswordAlterarUsuario() {
    if (document.formPassword.txtChangePassword.value == "") {
        alert("Campo senha não Informado");
        return false;
    }
    if (document.formPassword.txtConfirmChangePassword.value == "") {
        alert("Campo confirmar senha não Informado");
        return false;
    }
    if (document.formPassword.txtChangePassword.value != document.formPassword.txtConfirmChangePassword.value) {
        alert("Senha e confirmar senha com valores diferentes");
        return false;
    }

    document.formPassword.submit();
}
function validarEmailAlterarUsuario() {
    if (document.formEmail.txtChangeEmail.value == "") {
        alert("Campo email não Informado");
        return false;
    }

    document.formEmail.submit();
}