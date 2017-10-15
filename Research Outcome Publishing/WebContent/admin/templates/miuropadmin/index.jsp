<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
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
		<footer id="footer">
			<ul>
				<c:forEach	var="module" items="${modules}">
					<li><a href="<c:url value="/?m=${encryptor.encrypt(module)}" />"><c:out value="${module}" /></a></li>
				</c:forEach>
				<c:forEach	var="module" items="${adminModules}">
					<li><a href="<c:url value="/admin?m=${encryptor.encrypt(module)}" />"><c:out value="${module}" /></a></li>
				</c:forEach>
			</ul>
		</footer>
	</body>
</html>