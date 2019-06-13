<%-- 
    Document   : Home
    Created on : 10/06/2019, 13:00:44
    Author     : kono
--%>
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
        <h1>Hello World!</h1>
        <div class="container">
            <form name="formNewPost" action="Post" method="post">
                Digite um novo post: <textarea name="txtAreaPost" rows="1" cols="40">
                </textarea>
                <input type="button" value="Postar" onclick="validaTextArea()"/>
            </form>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Email</th>
                        <th scope="col">Comentário</th>
                        <th scope="col"> </th>
                    </tr>
                </thead>
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
                                    <input type="submit" value="Ver detalhes"/>
                                </form>
                                <form name="formAlterarPost" action="Post" method="post">
                                    <input type="hidden" name="hiddenPostIDAlterar" value="${p.idPost}">
                                    <input type="hidden" name="hiddenPostEmailAlterar" value="${p.email}">
                                    <input type="hidden" name="hiddenPostValueAlterar" value="${p.postValue}">
                                    <input type="submit" value="Alterar Post"/>
                                </form>
                                <form name="formExcluirPost" action="Post" method="post">
                                    <input type="hidden" name="hiddenPostIDExcluir" value="${p.idPost}">
                                    <input type="hidden" name="hiddenPostEmailExcluir" value="${p.email}">
                                    <input type="hidden" name="hiddenPostValueExcluir" value="${p.postValue}">
                                    <input type="submit" value="Excluir Post"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>