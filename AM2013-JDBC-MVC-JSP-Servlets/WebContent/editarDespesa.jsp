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
	<title>Editar Despesa | Advocacia - AM</title>
</head>
<body>
	<div id="container">

		<jsp:include page="common/header.jsp">
			<jsp:param name="titulo" value="Editar Despesa" />
		</jsp:include>

		<jsp:include page="common/menu.html" />				

		<form action="alterarDespesa" method="post">
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
					<label for="despesa">Despesa: </label>
					<select name="despesa" id="despesa" disabled="disabled">
						<option value="">Selecione...</option>
						
						
						<c:forEach items="${tipoDList}" var="td">
						<option value="${td.descricao}" <c:choose><c:when test="${td.descricao == despesa.tipoDespesa.descricao}"> <c:out value="selected=\"selected\"" /> </c:when></c:choose>  >${td.descricao}</option>
						</c:forEach>
						
						
					</select>
				</div>
				<div class="inline">
					<label for="dataDespesa">Data da Despesa: </label><input type="text" name="dataDespesa" id="dataDespesa" value="<fmt:formatDate value="${despesa.dataDespesa}" pattern="dd/MM/yyyy"/>" />
				</div>
			</div>
			<div>
				<div class="inline">
					<label for="valorDespesa">Valor da Despesa: </label><input type="text" name="valorDespesa" id="valorDespesa" value="${vlDesp}" />
				</div>
				<div class="inline">
					<label for="observacoes">Observações: </label><textarea name="observacoes" id="observacoes">${despesa.obs}</textarea>
				</div>
			</div>
			<p><input class="btn btn-primary" type="submit" value="Gravar" /></p>
		</form>

		<jsp:include page="common/footer.html" />
	</div>

	<jsp:include page="common/bottom_scripts.html" />

</body>
</html>
