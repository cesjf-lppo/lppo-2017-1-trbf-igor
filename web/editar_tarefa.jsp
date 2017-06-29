    <%@page errorPage="erro.jsp"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@include file="jspf/cabecalho.jspf"%>
    <%@include file="jspf/menu.jspf"%>
    

        <div class="col-xs-8 col-xs-offset-2">
            
            <div class="panel panel-default">
                <div class="panel-heading">Editar Tarefa</div>
                <div class="panel-body">
                    <form method="post" class="form-horizontal" style="margin-top: 5%;">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">ID: </label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="id" value="${tarefas.id}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Título: </label>
                            <div class="col-sm-6">
                              <input type="text" class="form-control" name="titulo" value="${tarefas.titulo}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Descrição: </label>
                            <div class="col-sm-6">
                                <textarea class="form-control" cols="5" rows="3" name="descricao">${tarefas.descricao}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Data Concluir: </label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="data_concluir" value="<fmt:formatDate value="${tarefas.data_concluir}" pattern="dd/MM/yyyy" />">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Data Conclusão: </label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="data_conclusao" 
                                    <c:choose>
                                        <c:when test="${not empty tarefas.data_conclusao}">
                                            value="<fmt:formatDate value="${tarefas.data_conclusao}" pattern="dd/MM/yyyy" />"
                                        </c:when>
                                        <c:otherwise>
                                            placeholder="dd/mm/aaaa" required
                                        </c:otherwise>
                                    </c:choose>  
                                >
                            </div>
                        </div>
                        <div class="col-xs-12" style="text-align: center;margin-bottom: 2%;">
                            <input type="submit" class="btn btn-primary" value="Salvar"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    <%@include file="jspf/rodape.jspf"%>
