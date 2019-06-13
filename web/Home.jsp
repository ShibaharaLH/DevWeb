<%@page import="br.com.prototipoRedeSocial.models.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function validaTextArea() {
                if (document.formNewPost.txtAreaPost.value == "") {
                    alert("Campo não Informado");
                    return false;
                }

                document.formNewPost.submit();
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" color="info" href="#">Seja Bem vindo!</a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <form name="formConfigUser" action="ConfigUser.jsp" method="get">
                        <button class="btn btn-outline-info my-2 my-sm-0" type="submit" href="ConfigUser.jsp">Configuração</button>
                    </form>
                </ul>

                <form name="formLogin" action="Usuario" method="post">
                    <input type="hidden" name="hiddenLogout" value="logout">
                    <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Logout</button>
                </form>
            </div>
        </nav>


        <div class="container">
            <form name="formNewPost" action="Post" method="post">
                <br/>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Digite um novo post:</span>
                    </div>
                    <textarea name="txtAreaPost" class="form-control" aria-label="With textarea"></textarea>

                    <input type="button" value="Postar" class="btn btn-info my-2 my-sm-0" onclick="validaTextArea()"/>
                </div>
            </form>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Email</th>
                        <th scope="col">Comentário</th>
                        <th scope="col"> </th>
                    </tr>
                </thead>
                <br/>
                <tbody>
                    <c:forEach var="p" items="${postList}">
                        <tr>
                            <th scope="row">${p.email}</th>
                            <td>${p.postValue}</td>
                            <td>
                                <form name="formDetalhesPost" action="Post" method="get">
                                    <input type="hidden" name="hiddenPostID" value="${p.idPost}">
                                    <input type="hidden" name="hiddenPostEmail" value="${p.email}">
                                    <input type="hidden" name="hiddenPostValue" value="${p.postValue}">
                                    <input class="btn btn-info my-2 my-sm-0" type="submit" value="Ver detalhes"/>
                                </form><br>
                                <form name="formAlterarPost" action="Post" method="post">
                                    <input type="hidden" name="hiddenPostIDAlterar" value="${p.idPost}">
                                    <input type="hidden" name="hiddenPostEmailAlterar" value="${p.email}">
                                    <input type="hidden" name="hiddenPostValueAlterar" value="${p.postValue}">
                                    <input class="btn btn-info my-2 my-sm-0" type="submit" value="Alterar Post"/>
                                </form><br>
                                <form name="formExcluirPost" action="Post" method="post">
                                    <input type="hidden" name="hiddenPostIDExcluir" value="${p.idPost}">
                                    <input type="hidden" name="hiddenPostEmailExcluir" value="${p.email}">
                                    <input type="hidden" name="hiddenPostValueExcluir" value="${p.postValue}">
                                    <input class="btn btn-info my-2 my-sm-0" type="submit" value="Excluir Post"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>