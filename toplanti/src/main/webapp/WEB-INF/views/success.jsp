<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kayit Basari Sayfasi</title>
</head>
<body>
	message : ${success}
	<br />
	<br />
	<a href="<c:url value='/list' />">Kullanici listesine</a> geri don

</body>

</html>