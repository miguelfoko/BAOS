<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="${title} | ${configManager.platformTitle}" /></title>
<c:forEach var="css" items="${cssList}">
	<link rel="stylesheet" type="text/css" href="<c:url value="${css}" />" />
</c:forEach>
<link rel="stylesheet" type="text/css" href="<c:url value="/ressources/jquery-ui/theme/miuniverse/jquery.ui.all.css" />" />
<link rel="icon" type="image/png" href="<c:url value="/ressources/images/logo-baos.png" />" />
<script type="text/javascript" src="<c:url value="/ressources/jquery/jquery-1.9.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/ressources/jquery-ui/jquery-ui-1.8.13.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/ressources/jquery.scrollto/jquery.scrollTo.js" />"></script>
<script type="text/javascript" src="<c:url value="/ressources/js/util.js" />"></script>
<c:forEach var="js" items="${jsList}">
	<script type="text/javascript" src="<c:url value="${js}" />"></script>
</c:forEach>