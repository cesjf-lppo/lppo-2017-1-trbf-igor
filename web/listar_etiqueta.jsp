    <%@page errorPage="erro.jsp"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="jspf/cabecalho.jspf"%>
    <%@include file="jspf/menu.jspf"%>
        
        <div class="col-xs-8 col-xs-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading">Listar Etiquetas</div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Título</th>
                                    <th>Autor</th>
                                    <th>Tarefa</th>
                                    <th>Ações</th>
                                </tr>   
                            </thead>
                            <tbody>
                                <c:choose>
                                    <c:when test="${not empty etiquetas}">
                                        <c:forEach var="etiqueta" items="${etiquetas}">
                                            <tr>
                                                <td>${etiqueta.id}</td>
                                                <td>${etiqueta.titulo}</td>
                                                <td>${etiqueta.usuario.nome_completo}</td>
                                                <td>${etiqueta.tarefa.titulo}</td>
                                                <td>
                                                    <span class="glyphicon glyphicon-remove" onclick="document.location.href='excluirEtiqueta.html?id=${etiqueta.id}'" style="cursor: pointer;"></span>
                                                    <span class="glyphicon glyphicon-pencil" onclick="document.location.href='editarEtiqueta.html?id=${etiqueta.id}'" style="cursor: pointer;"></span>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td style="text-align: center;" colspan="7">
                                                Nenhuma etiqueta cadastrada!
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
