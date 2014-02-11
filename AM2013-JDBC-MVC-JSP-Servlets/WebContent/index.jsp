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

		<jsp:include page="common/footer.html" />
	</div>

	<jsp:include page="common/bottom_scripts.html" />

</body>
</html>
