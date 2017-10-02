<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<c:import url="/ressources/jsp/header.jsp" />
	</head>
	<body>
		<c:if test="${error != null}">
			<div class="error">
				<c:out value="${error}" />
			</div>
		</c:if>
		<c:if test="${success != null}">
			<div class="success">
				<c:out value="${success}" />
			</div>
		</c:if>
		<div id="main">
			<c:forEach var="page" items="${listeInclude}">
				<c:import url="${page}" />
			</c:forEach>
		</div>
	</body>
</html>