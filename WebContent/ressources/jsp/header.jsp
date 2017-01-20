<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="ROP - ${title}" /></title>
<c:forEach var="css" items="${listeCss}">
	<link rel="stylesheet" type="text/css" href="<c:url value="${css}" />" />
</c:forEach>
<link rel="stylesheet" type="text/css" href="<c:url value="/ressources/js/theme/miuniverse/jquery.ui.all.css" />" />
<link rel="icon" type="image/png" href="<c:url value="/ressources/images/logo-rop.png" />" />
<script type="text/javascript" src="<c:url value="/ressources/js/jquery-1.7.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/ressources/js/jquery-ui-1.8.13.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/ressources/js/util.js" />"></script>
<c:forEach var="js" items="${listeJs}">
	<script type="text/javascript" src="<c:url value="${js}" />"></script>
</c:forEach>