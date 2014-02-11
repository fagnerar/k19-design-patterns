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
	<title>Lançar Honorário | Advocacia - AM</title>
</head>
<body>
	<div id="container">

		<jsp:include page="common/header.jsp">
			<jsp:param name="titulo" value="Lançar Honorário" />
		</jsp:include>

		<jsp:include page="common/menu.html" />

		<form action="lancarHonoSetup" method="post">
			<input type="hidden" name="valorHoraAdv" id="valorHoraAdv" value="50.0" />
			<div>
				<div class="inline">
					<label for="processo">Número do Processo: </label><input type="text" name="processo" id="processo" value="${sessionScope.proc.nroProcesso}" disabled="disabled" />
				</div>
				<div class="inline">
					<label for="cliente">Nome do Cliente: </label><input type="text" name="cliente" id="cliente" value="${sessionScope.proc.cliente.nome}" disabled="disabled" />
				</div>
			</div>
			<div>
				<div class="inline">
					<label for="advogado">Advogado</label><input type="text" name="advogado" id="advogado" value="${proc2.advogado.nome}" disabled="disabled" />
				</div>
				<div class="inline">
					<label for="tipoTar">Honorário: </label>
					<select name="tipoTar" id="tipoTar">
						
						
						<option value="" selected="selected" >Selecione...</option>
						
						<c:forEach items="${tipoTList}" var="tt">
						<option value="${tt.descricao}">${tt.descricao}</option>
						</c:forEach>
						
						
					</select>
				</div>
			</div>
			<div>
				<div class="inline">
					<label for="dataHonorario">Data do Honorário: </label><input type="text" name="dataHonorario" id="dataHonorario" value="<fmt:formatDate value="${honorario.dataHonorario}" pattern="dd/MM/yyyy"/>" />
				</div>
				<div class="inline">
					<label for="qtdeHoras">Quantidade de Horas: </label><input type="text" name="qtdeHoras" id="qtdeHoras" value="${honorario.qtdeHoras}" />
				</div>
			</div>
			<div>
				<div class="inline">
					<label for="valorHonorario">Total do Honorário: </label><input type="text" name="valorHonorario" id="valorHonorario" value="${honorario.qtdeHoras * proc2.advogado.horaAdvogado.valorHora}" disabled="disabled" />
				</div>
				<div class="inline">
					<label for="observacoes">Observações: </label><textarea name="observacoes" id="observacoes"></textarea>
				</div>
			</div>
			<p><input class="btn btn-primary" type="submit" value="Gravar" /></p>
		</form>

		<jsp:include page="common/footer.html" />
	</div>

	<jsp:include page="common/bottom_scripts.html" />

</body>
</html>
