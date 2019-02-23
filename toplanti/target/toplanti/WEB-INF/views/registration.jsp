<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration Form</title>

<style>
.error {
	color: #ff0000;
}
</style>

</head>

<body>

	<h2>KayÄ±t Formu</h2>

	<form:form method="POST" modelAttribute="kullanici">
		<form:input type="hidden" path="id" id="id" />
		<table>
			<tr>
				<td><label for="name">Ad: </label></td>
				<td><form:input path="ad" id="ad" /></td>
				<td><form:errors path="ad" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="soyad">Soyad: </label></td>
				<td><form:input path="soyad" id="soyad" /></td>
				<td><form:errors path="soyad" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="DogumTarihi">Dogum Tarihi: </label></td>
				<td><form:input path="DogumTarihi" id="DogumTarihi" /></td>
				<td><form:errors path="DogumTarihi" cssClass="error" /></td>
			</tr>


			<tr>
				<td><label for="Tckn">Tckn: </label></td>
				<td><form:input path="Tckn" Tckn="Tckn" /></td>
				<td><form:errors path="Tckn" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td><label for="birim">Birim: </label></td>
				<td><form:input path="birim" birim_id="birim" /></td>
				<td><form:errors path="birim" cssClass="error" /></td>
			</tr>
			
				<tr>
				<td><label for="rol">Rol: </label></td>
				<td><form:input path="rol" rol_id="rol" /></td>
				<td><form:errors path="rol" cssClass="error" /></td>
			</tr>
			
		

			<tr>
				<td colspan="3"><c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" />
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</form:form>
	<br />
	<br />
	<a href="<c:url value='/list' />">Kullanıcı Listesine Dön</a> geri dÃ¶n
</body>
</html>