<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>${news_home_page}</title>
<link type="text/css" rel="stylesheet"
	href="admin/modules/journal/inc/style.css" />
<script type="text/javascript" src="admin/modules/journal/inc/fonction.js"></script>
</head>
<body>
	<div id="regButtons" class="2-b_article lst-b_article b_article">
<%-- 			<a href="<c:url value="/?m=${applicationScope.encryptor.encrypt('news')}&ob=${applicationScope.encryptor.encrypt('create')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('news_create_news', sessionScope.tag)}" /></a> --%>
<%-- 			<br><a href="<c:url value="/?m=${applicationScope.encryptor.encrypt('news')}&ob=${applicationScope.encryptor.encrypt('list')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('news_list', sessionScope.tag)}" /></a> --%>
	</div>
</body>
</html>