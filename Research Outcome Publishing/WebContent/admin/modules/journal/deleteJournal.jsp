<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title><c:out value="${applicationScope.languageManager.getLanguageValue('journal_delete_title', sessionScope.tag)}" /></title>
<link type="text/css" rel="stylesheet"
	href="admin/modules/journal/inc/style.css" />
<script type="text/javascript" src="admin/modules/journal/inc/fonction.js"></script>
</head>
<body>
	<div>
		<form method="post"
			action="<c:url value="/?m=${applicationScope.encryptor.encrypt('adminJournal')}" />&o=${applicationScope.encryptor.encrypt('ModAdminJournal')}"
			name="formUpdate" onsubmit="return verifFormX(formUpdate);" >
			<fieldset>
			    <input type="hidden" name="formulaire" value="${applicationScope.encryptor.encrypt('formDelete')}">
				<legend><c:out value="${applicationScope.languageManager.getLanguageValue('journal_information', sessionScope.tag)}" /> </legend>
				<label for="journalOrConfName"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_name', sessionScope.tag)}" /><span
					class="requis">*</span></label> <input type="text" id="journalOrConfName"
					name="journalOrConfName" value="${journalOrConfName }" size="30" maxlength="30"
					onblur="verifPseudo(this);" />
					<span class="requis">
<c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_msg1', sessionScope.tag)}" />
</span>
					 <br /> <label
					for="journalOrConfName"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_type', sessionScope.tag)}" /> <span
					class="requis">*</span></label> <select id="journalOrConfType"
					name="journalOrConfType">
					<option>Journal</option>
					<option>Conference</option>
				</select> 
			</fieldset>
			<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('journal_delete_submit_button', sessionScope.tag)}" />" name="submitValue"/> <input
				type="reset" value="<c:out value="${applicationScope.languageManager.getLanguageValue('journal_cancel_button', sessionScope.tag)}" />" /> <br />
		</form>
		<br><br><font color="red" size="18">${resultOfDelete } </font>
	</div>
</body>
</html>