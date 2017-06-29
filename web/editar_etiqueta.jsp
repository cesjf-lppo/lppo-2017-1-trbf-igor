    <%@page errorPage="erro.jsp"%>
    <%@include file="jspf/cabecalho.jspf"%>
    <%@include file="jspf/menu.jspf"%>
    

        <div class="col-xs-8 col-xs-offset-2">
            
            <div class="panel panel-default">
                <div class="panel-heading">Editar Etiqueta</div>
                <div class="panel-body">
                    <form method="post" class="form-horizontal" style="margin-top: 5%;">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">ID: </label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="titulo" value="${etiqueta.id}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Título: </label>
                            <div class="col-sm-6">
                              <input type="text" class="form-control" name="titulo" value="${etiqueta.titulo}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Autor: </label>
                            <div class="col-sm-3">
                              <input type="text" class="form-control" name="id_usuario" value="${etiqueta.usuario.id}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Tarefa: </label>
                            <div class="col-sm-3">
                              <input type="text" class="form-control" name="id_tarefa" value="${etiqueta.tarefa.id}">
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
