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
	<title>Listar Processos | Advocacia - AM</title>
</head>
<body>
	<div id="container">

		<jsp:include page="common/header.jsp">
			<jsp:param name="titulo" value="Listar Processos" />
		</jsp:include>

		<jsp:include page="common/menu.html" />

		<form action="" method="post">
			<div>
				<div class="inline">
					<label for="processo">Número do Processo: </label><input type="text" name="processo" id="processo" />
				</div>
				<div class="inline">
					<label for="cliente">Nome do Cliente: </label><input type="text" name="cliente" id="cliente" />
				</div>
			</div>
			<div>
				<div class="inline">
					<label for="dataInicial">Período: </label><input type="text" name="dataInicial" id="dataInicial" />
				</div>
				<div class="inline">
					<label for="dataFinal">Até: </label><input type="text" name="dataFinal" id="dataFinal" />
				</div>
			</div>
			<p><input class="btn btn-primary" type="submit" value="Buscar" /></p>
		</form>

		<table style="width: 800px" class="table table-striped table-bordered table-condensed">
			<caption>Lista de processos - Advocacia </caption>     
			<thead>
				<tr>
					<th>Número</th>
					<th>Descrição</th>
					<th>Cliente</th>
					<th>Honorários</th>
					<th>Despesas</th>
				</tr>
			</thead>
			<tbody>
				
				
				
				
				<c:forEach items="${procList}" var="p">
				
					<tr>
						<td>${p.nroProcesso}</td>
						<td>${p.descricao}</td>
						<td>${p.cliente.razaoSocial}</td>
						
						<td>
							<p><a href="listarHonorario?nroProc=${p.nroProcesso}"><img src="img/listar.png" alt="Listar" /> Listar Honorários</a></p>
							<p><a href="lancarHonorario?nroProc=${p.nroProcesso}"><img src="img/lancar.png" alt="Lançar" /> Lançar Honorário</a></p>
						</td>
						<td>
							<p><a href="listarDespesa?nroProc=${p.nroProcesso}"><img src="img/listar.png" alt="Listar" /> Listar Despesas</a></p>
							<p><a href="lancarDesp?nroProc=${p.nroProcesso}"><img src="img/lancar.png" alt="Lançar" /> Lançar Despesa</a></p>
						</td>
						
					</tr>
					
				</c:forEach>
								
				
			</tbody>    
		</table>

		<jsp:include page="common/footer.html" />
	</div>

	<jsp:include page="common/bottom_scripts.html" />

</body>
</html>
