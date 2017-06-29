    <%@page errorPage="erro.jsp"%>
    <%@include file="jspf/cabecalho.jspf"%>
    <%@include file="jspf/menu.jspf"%>
    

        <div class="col-xs-8 col-xs-offset-2">
            
            <div class="panel panel-default">
                <div class="panel-heading">Cadastro de Etiqueta</div>
                <div class="panel-body">
                    <form method="post" class="form-horizontal" style="margin-top: 5%;">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Título: </label>
                            <div class="col-sm-6">
                              <input type="text" class="form-control" name="titulo" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Autor: </label>
                            <div class="col-sm-3">
                              <input type="text" class="form-control" name="id_usuario" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Tarefa: </label>
                            <div class="col-sm-3">
                              <input type="text" class="form-control" name="id_tarefa" required>
                            </div>
                        </div>
                        <div class="col-xs-12" style="text-align: center;margin-bottom: 2%;">
                             <input type="reset" class="btn btn-danger" value="Cancelar"/>
                            <input type="submit" class="btn btn-primary" value="Cadastrar"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    <%@include file="jspf/rodape.jspf"%>
