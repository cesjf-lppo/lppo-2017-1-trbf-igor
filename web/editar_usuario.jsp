    <%@page errorPage="erro.jsp"%>
    <%@include file="jspf/cabecalho.jspf"%>
    <%@include file="jspf/menu.jspf"%>
    

        <div class="col-xs-8 col-xs-offset-2">
            
            <div class="panel panel-default">
                <div class="panel-heading">Editar Usuário</div>
                <div class="panel-body">
                    <form method="post" class="form-horizontal" style="margin-top: 5%;">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">ID: </label>
                            <div class="col-sm-6">
                              <input type="text" class="form-control" name="id" value="${usuario.id}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Nome Completo: </label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="nome_completo" value="${usuario.nome_completo}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Email: </label>
                            <div class="col-sm-6">
                              <input type="text" class="form-control" name="email" value="${usuario.email}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Senha </label>
                            <div class="col-sm-6">
                              <input type="password" class="form-control" name="senha" value="${usuario.senha}">
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
