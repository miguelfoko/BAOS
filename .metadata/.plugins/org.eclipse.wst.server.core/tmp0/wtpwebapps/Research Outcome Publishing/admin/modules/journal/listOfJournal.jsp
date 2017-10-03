<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title><c:out value="${applicationScope.languageManager.getLanguageValue('journal_list_of_journal_title', sessionScope.tag)}" /></title>
<link type="text/css" rel="stylesheet"
	href="admin/modules/journal/inc/style.css" />
<script type="text/javascript" src="admin/modules/journal/inc/fonction.js"></script>
</head>
<body>
<div>
	<fieldset>
	<legend><c:out value="${applicationScope.languageManager.getLanguageValue('journal_list_journal', sessionScope.tag)}" /> </legend>
		<table  border=1>
			<thead>
				<tr>
					<th width="5%">${applicationScope.languageManager.getLanguageValue('journal_trash_journal_id', sessionScope.tag)}</th>
					<th width="20%">${applicationScope.languageManager.getLanguageValue('journal_trash_journal_name', sessionScope.tag)}</th>
					<th width="15%">${applicationScope.languageManager.getLanguageValue('journal_trash_journal_type', sessionScope.tag)}</th>
					<th width="20%">${applicationScope.languageManager.getLanguageValue('journal_trash_journal_logo', sessionScope.tag)}</th>
					<th width="15%">${applicationScope.languageManager.getLanguageValue('journal_trash_journal_short_desc', sessionScope.tag)}</th>
					<th width="50%">${applicationScope.languageManager.getLanguageValue('journal_trash_journal_long_desc', sessionScope.tag)}</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${baoJournalOrConf}" var="v">
					<tr>
						<td width="5%"><c:out value="${v['journalOrConfId']}"></c:out></td>
						<td width="20%"><c:out value="${v['journalOrConfName']}"></c:out></td>
						<td width="15%"><c:out value="${v['journalOrConfType']}"></c:out></td>
						<td width="20%"><img src="<c:out value="${v['journalOrConfLogo']}"></c:out>" with="100" height="100" align="center" /></td>
						<td width="15%"><c:out value="${v['journalOrConfShortDesc']}"></c:out></td>
						<td width="50%"><c:out value="${v['journalOrConfLongDesc']}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
</div>
</body>
</html>
