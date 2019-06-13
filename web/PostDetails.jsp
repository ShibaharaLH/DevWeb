<%-- 
    Document   : Home
    Created on : 10/06/2019, 13:00:44
    Author     : kono
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function validaTextArea() {
                if (document.formNewPostComment.txtAreaPostComment.value == "") {
                    alert("Campo não Informado");
                    return false;
                }
                document.formNewPostComment.submit();
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <form name="formhome" action="Home.jsp" method="get">
                <button class="btn btn-outline-info my-2 my-sm-0" type="submit" href="Home.jsp">Voltar</button>
            </form>
            <a class="navbar-brand" color="info" href="#"></a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <form name="formConfigUser" action="ConfigUser.jsp" method="get">
                        <button class="btn btn-outline-info my-2 my-sm-0" type="submit" href="ConfigUser.jsp">Configuração</button>
                    </form>
                </ul>

                <form name="formLogin" action="Login.jsp" method="get">

                    <button class="btn btn-outline-info my-2 my-sm-0" type="submit" href="Login.jsp">Logout</button>
                </form>
            </div>
        </nav>
        <br/>
        <div class="container">
            <form name="formNewPostComment" action="PostComment" method="post">
                <br/>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Digite um novo comentário:</span>
                    </div>
                    <textarea name="txtAreaPostComment" class="form-control" aria-label="With textarea"></textarea>

                    <input type="button" value="Postar" class="btn btn-info my-2 my-sm-0" onclick="validaTextArea()"/>
                </div>
            </form>
            <br/>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Email</th>
                        <th scope="col">Comentário</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="p" items="${postDetails}">
                        <tr>
                            <th scope="row">${p.email}</th>
                            <td>${p.commentValue}</td>
                            <td>
                                <form name="formAlterarPostComment" action="PostComment" method="post">
                                    <input type="hidden" name="hiddenIdPostAlterar" value="${p.idPost}">
                                    <input type="hidden" name="hiddenPostCommentIDAlterar" value="${p.idPostComment}">
                                    <input type="hidden" name="hiddenPostCommentEmailAlterar" value="${p.email}">
                                    <input type="hidden" name="hiddenPostCommentValueAlterar" value="${p.commentValue}">
                                    <input class="btn btn-info my-2 my-sm-0" type="submit" value="Alterar Post Comment"/>
                                </form><br>
                                <form name="formExcluirPost" action="PostComment" method="post">
                                    <input type="hidden" name="hiddenIdPostExcluir" value="${p.idPost}">
                                    <input type="hidden" name="hiddenPostCommentIDExcluir" value="${p.idPostComment}">
                                    <input type="hidden" name="hiddenPostCommentEmailExcluir" value="${p.email}">
                                    <input type="hidden" name="hiddenPostCommentValueExcluir" value="${p.commentValue}">
                                    <input class="btn btn-info my-2 my-sm-0" type="submit" value="Excluir Post Comment"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>