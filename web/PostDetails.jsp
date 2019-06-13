<%-- 
    Document   : Home
    Created on : 10/06/2019, 13:00:44
    Author     : kono
--%>
<%@page import="br.com.prototipoRedeSocial.models.PostComment"%>
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
        <h1>Hello World!</h1>
        <div class="container">
            <form name="formNewPostComment" action="PostComment" method="post">
                Digite um novo post comment: <textarea name="txtAreaPostComment" rows="1" cols="40">
                </textarea>
                <input type="button" value="Postar" onclick="validaTextArea()"/>
            </form>

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
                                    <input type="submit" value="Alterar Post Comment"/>
                                </form>
                                <form name="formExcluirPost" action="PostComment" method="post">
                                    <input type="hidden" name="hiddenIdPostExcluir" value="${p.idPost}">
                                    <input type="hidden" name="hiddenPostCommentIDExcluir" value="${p.idPostComment}">
                                    <input type="hidden" name="hiddenPostCommentEmailExcluir" value="${p.email}">
                                    <input type="hidden" name="hiddenPostCommentValueExcluir" value="${p.commentValue}">
                                    <input type="submit" value="Excluir Post Comment"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>