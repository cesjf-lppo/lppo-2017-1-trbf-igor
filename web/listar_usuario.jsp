    <%@page errorPage="erro.jsp"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="jspf/cabecalho.jspf"%>
    <%@include file="jspf/menu.jspf"%>
        
        <div class="col-xs-8 col-xs-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading">Listar Usuários</div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome Completo</th>
                                    <th>Email</th>
                                    <th>Ações</th>
                                </tr>   
                            </thead>
                            <tbody>
                                <c:choose>
                                    <c:when test="${not empty usuarios}">
                                        <c:forEach var="usuario" items="${usuarios}">
                                            <tr>
                                                <td>${usuario.id}</td>
                                                <td>${usuario.nome_completo}</td>
                                                <td>${usuario.email}</td>
                                                <td>
                                                    <span class="glyphicon glyphicon-remove" onclick="document.location.href='excluir.html?id=${usuario.id}'" style="cursor: pointer;"></span>
                                                    <span class="glyphicon glyphicon-pencil" onclick="document.location.href='editar.html?id=${usuario.id}'" style="cursor: pointer;"></span>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td style="text-align: center;" colspan="7">
                                                Nenhum usuário cadastrado!
                                            </td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                                
                        </table>
                    </div>
                </div>
            </div>
        </div>
    
    <%@include file="jspf/rodape.jspf"%>
