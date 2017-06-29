    <%@page errorPage="erro.jsp"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@include file="jspf/cabecalho.jspf"%>
    <%@include file="jspf/menu.jspf"%>
        
        <div class="col-xs-8 col-xs-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading">Listar Tarefas</div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Título</th>
                                    <th>Descrição</th>
                                    <th>Data Concluir</th>
                                    <th>Ações</th>
                                </tr>   
                            </thead>
                            <tbody>
                                <c:choose>
                                    <c:when test="${not empty tarefas}">
                                        <c:forEach var="tarefa" items="${tarefas}">
                                            <tr>
                                                <td>${tarefa.id}</td>
                                                <td>${tarefa.titulo}</td>
                                                <td>${tarefa.descricao}</td>
                                                <td><fmt:formatDate value="${tarefa.data_concluir}" pattern="dd/MM/yyyy" /></td>
                                                <td>
                                                    <span class="glyphicon glyphicon-remove" onclick="document.location.href='excluirTarefa.html?id=${tarefa.id}'" style="cursor: pointer;"></span>
                                                    <span class="glyphicon glyphicon-pencil" onclick="document.location.href='editarTarefa.html?id=${tarefa.id}'" style="cursor: pointer;"></span>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td style="text-align: center;" colspan="7">
                                                Nenhuma tarefa cadastrada!
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
