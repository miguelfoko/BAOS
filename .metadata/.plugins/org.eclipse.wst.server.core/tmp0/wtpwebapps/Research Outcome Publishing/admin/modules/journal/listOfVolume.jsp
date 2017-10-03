<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title><c:out value="${applicationScope.languageManager.getLanguageValue('journal_list_of_volume_title', sessionScope.tag)}" /></title>
<link type="text/css" rel="stylesheet"
	href="admin/modules/journal/inc/style.css" />
<script type="text/javascript" src="admin/modules/journal/inc/fonction.js"></script>
</head>
<body>
<div>
	<fieldset>
	<legend><c:out value="${applicationScope.languageManager.getLanguageValue('journal_volume_list', sessionScope.tag)}" /> </legend>
		<table  border=1>
			<thead>
				<tr>
					<th width="150px">${applicationScope.languageManager.getLanguageValue('journal_volume_id', sessionScope.tag)}</th>
					<th width="250px">${applicationScope.languageManager.getLanguageValue('journal_volume_issue_identifier', sessionScope.tag)}</th>
					<th width="250px">${applicationScope.languageManager.getLanguageValue('journal_volume_issue_submission_deadline', sessionScope.tag)}</th>
					<th width="250px">${applicationScope.languageManager.getLanguageValue('journal_volume_issue_desc', sessionScope.tag)}</th>
					<th width="100px">${applicationScope.languageManager.getLanguageValue('journal_volume_issue_state', sessionScope.tag)}</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${baoVolumeOrIssue}" var="v">
					<tr>
						<td width="150px"><c:out value="${v['volumeOrIssueId']}"></c:out></td>
						<td width="250px"><c:out value="${v['volumeOrIssueIdentifier']}"></c:out></td>
						<td width="250px"><c:out value="${v['volumeOrIssueSubmissionDeadline']}"></c:out></td>
						<td width="350px"><c:out value="${v['volumeOrIssueDesc']}"></c:out></td>
						<td width="100px"><c:out value="${v['volumeOrIssueState']}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
</div>
</body>
</html>
