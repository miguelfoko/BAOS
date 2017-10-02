<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title><c:out value="${applicationScope.languageManager.getLanguageValue('news_list__title', sessionScope.tag)}" /></title>
<link type="text/css" rel="stylesheet"
	href="admin/modules/journal/inc/style.css" />
<script type="text/javascript" src="admin/modules/journal/inc/fonction.js"></script>
</head>
<body>
<div>
	<fieldset>
		<legend><c:out value="${applicationScope.languageManager.getLanguageValue('news_list', sessionScope.tag)}" /> </legend>
		<table border=1>
			<thead>
				<tr>
					<th width="5%">${applicationScope.languageManager.getLanguageValue('news_id', sessionScope.tag)}</th>
					<th width="10%">${applicationScope.languageManager.getLanguageValue('news_title', sessionScope.tag)}</th>
					<th width="10%">${applicationScope.languageManager.getLanguageValue('news_key', sessionScope.tag)}</th>
					<th width="10%">${applicationScope.languageManager.getLanguageValue('news_language', sessionScope.tag)}</th>
					<th width="5%">${applicationScope.languageManager.getLanguageValue('news_is_traduction', sessionScope.tag)}</th>
					<th width="35%">${applicationScope.languageManager.getLanguageValue('news_content', sessionScope.tag)}</th>
					<th width="10%">${applicationScope.languageManager.getLanguageValue('news_date', sessionScope.tag)}</th>
					<th width="10%">${applicationScope.languageManager.getLanguageValue('news_keyword', sessionScope.tag)}</th>
					<th width="5%">${applicationScope.languageManager.getLanguageValue('news_state', sessionScope.tag)}</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${baoNews}" var="v">
					<tr>
						<td width="5%"><c:out value="${v['newsId']}"></c:out></td>
						<td width="10%"><c:out value="${v['newsTitle']}"></c:out></td>
						<td width="10%"><c:out value="${v['newsKey']}"></c:out></td>
						<td width="10%"><c:out value="${v['newsLanguage']}"></c:out></td>
						<td width="5%"><c:out value="${v['newsIsTraduction']}"></c:out></td>
						<td width="35%"><c:out value="${v['newsContent']}"></c:out></td>
						<td width="10%"><c:out value="${v['newsDate']}"></c:out></td>
						<td width="10%"><c:out value="${v['newsKeywords']}"></c:out></td>
						<td width="5%"><c:out value="${v['newsState']}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
</div>
</body>
</html>