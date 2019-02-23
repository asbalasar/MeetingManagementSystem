<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>University Enrollments</title>

<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>

</head>

<body>
	<h2>Kullanici Listesi</h2>
	<table>
		<tr>
			<td>isim</td>
			<td>Joining Date</td>
			<td>Adres</td>
			<td>SSN</td>
			<td>Birim</td>
			<td>Rol</td>
		
		
			<td></td>
		</tr>
		<c:forEach items="${kullanicilar}" var="kullanici">
			<tr>
				<td>${kullanici.ad}</td>
				<td>${kullanici.soyad}</td>
				<td>${kullanici.DogumTarihi}</td>
				<td>${kullanici.adres}</td>
				<td>${kullanici.Tckn}</td>
				<td>${kullanici.birim}</td>
				<td>${kullanici.rol}</td>	
				<td><a
					href="<c:url value='/edit-${kullanici.ssn}-kullanici' />">${kullanici.ssn}</a></td>
				<td><a
					href="<c:url value='/delete-${kullanici.ssn}-kullanici' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="<c:url value='/new' />">Yeni Kullanici Ekle</a>
</body>
</html>