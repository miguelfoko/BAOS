<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>${journal_title}</title>
<link type="text/css" rel="stylesheet"
	href="admin/modules/journal/inc/style.css" />
<script type="text/javascript" src="admin/modules/journal/inc/fonction.js"></script>
</head>
<body>
	<div id="regButtons" class="2-b_article lst-b_article b_article">
<%-- 			<br><a href="<c:url value="/?m=${applicationScope.encryptor.encrypt('adminJournal')}&ob=${applicationScope.encryptor.encrypt('update')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_update_journal', sessionScope.tag)}" /></a> --%>
<%-- 			<br><a href="<c:url value="/?m=${applicationScope.encryptor.encrypt('adminJournal')}&ob=${applicationScope.encryptor.encrypt('delete')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_delete_journal', sessionScope.tag)}" /></a> --%>
<%-- 			<br><a href="<c:url value="/?m=${applicationScope.encryptor.encrypt('adminJournal')}&ob=${applicationScope.encryptor.encrypt('listOfJournal')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_list_of_journal', sessionScope.tag)}" /></a> --%>
<%-- 			<br><a href="<c:url value="/?m=${applicationScope.encryptor.encrypt('adminJournal')}&ob=${applicationScope.encryptor.encrypt('listOfConf')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_list_of_conf', sessionScope.tag)}" /></a> --%>
<%-- 			<br><a href="<c:url value="/?m=${applicationScope.encryptor.encrypt('adminJournal')}&ob=${applicationScope.encryptor.encrypt('trashList')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_trash_list', sessionScope.tag)}" /></a> --%>
<%-- 			<br><a href="<c:url value="/?m=${applicationScope.encryptor.encrypt('adminJournal')}&ob=${applicationScope.encryptor.encrypt('createReviewCondition')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_review_creation', sessionScope.tag)}" /></a> --%>
<%-- 			<br><a href="<c:url value="/?m=${applicationScope.encryptor.encrypt('adminJournal')}&ob=${applicationScope.encryptor.encrypt('createVolume')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_volume_creation', sessionScope.tag)}" /></a> --%>
<%-- 			<br><a href="<c:url value="/?m=${applicationScope.encryptor.encrypt('adminJournal')}&ob=${applicationScope.encryptor.encrypt('listOfVolume')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_volume_list', sessionScope.tag)}" /></a> --%>
		</div>
</body>
</html>