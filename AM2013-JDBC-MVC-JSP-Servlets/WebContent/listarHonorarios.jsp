<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<link href="css/bootstrap.css" rel="stylesheet" media="screen" />
	<link href="css/bootstrap-responsive.css" rel="stylesheet" />
	<link href="css/advocacia.css" rel="stylesheet" />
	<link href="css/fiap-am/jquery-ui-1.10.3.custom.css" rel="stylesheet" />
	<title>Listar Honorários | Advocacia - AM</title>
</head>
<body>
	<div id="container">

		<jsp:include page="common/header.jsp">
			<jsp:param name="titulo" value="Listar Honorários" />
		</jsp:include>

		<jsp:include page="common/menu.html" />

		<div>
			<div class="inline">
				<label for="processo">Número do Processo: </label><input type="text" name="processo" id="processo" value="${sessionScope.proc.nroProcesso}" disabled="disabled" />
			</div>
			<div class="inline">
				<label for="cliente">Nome do Cliente: </label><input type="text" name="cliente" id="cliente" value="${sessionScope.proc.cliente.nome}" disabled="disabled" />
			</div>
		</div>

		<table style="width: 800px" class="table table-striped table-bordered table-condensed">
			<caption>Lista de Honorários do Processo</caption>     
			<thead>
				<tr>
					<th>Data</th>
					<th>Nome</th>
					<th>Quantidade de Horas</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
			
			
			
				<c:forEach items="${honoList}" var="h">
					<tr>
						<td><fmt:formatDate value="${h.dataHonorario}" pattern="dd/MM/yyyy"/></td>
						<td>${h.tipoTarefa.descricao}</td>
						<td>${h.qtdeHoras}</td> 
						<td>
							<p><a href="excluirHonorario?cdHono=${h.cdHonorario}"><img src="img/apagar.png" alt="Excluir" /> Excluir</a></p>
							<p><a href="consultarHonorario?cdHono=${h.cdHonorario}"><img src="img/editar.png" alt="Editar" /> Editar</a></p>
						</td>
					</tr>
				</c:forEach>
				
				
				
			</tbody>    
		</table>

		<ul id="pager">
			<li class="primeira"><a href="#" class="btn btn-primary"> &lt; &lt; </a></li>
			<li class="anterior"><a href="#" class="btn btn-primary"> &lt; </a></li>
			<li class="pagina"><a href="#" class="btn">1</a></li>
			<li class="pagina"><a href="#" class="btn btn-primary">2</a></li>
			<li class="pagina"><a href="#" class="btn">3</a></li>
			<li class="pagina"><a href="#" class="btn">4</a></li>
			<li class="pagina"><a href="#" class="btn">5</a></li>
			<li class="proxima"><a href="#" class="btn btn-primary"> &gt; </a></li>
			<li class="ultima"><a href="#" class="btn btn-primary"> &gt; &gt; </a></li>
		</ul>

		<jsp:include page="common/footer.html" />
	</div>

	<jsp:include page="common/bottom_scripts.html" />

</body>
</html>
