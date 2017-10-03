<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title><c:out value="${applicationScope.languageManager.getLanguageValue('journal_creation_title', sessionScope.tag)}" /></title>
<link type="text/css" rel="stylesheet"
	href="admin/modules/journal/inc/style.css" />
<script type="text/javascript" src="admin/modules/journal/inc/fonction.js"></script>
</head>
<body>
	<div>
		<form method="post"
			action="<c:url value="/?m=${applicationScope.encryptor.encrypt('adminJournal')}" />&o=${applicationScope.encryptor.encrypt('ModAdminJournal')}"
			name="f1" onsubmit="return verifForm(f1);"
			enctype="multipart/form-data">
			<fieldset>
			<input type="hidden" name="formulaire" value="${applicationScope.encryptor.encrypt('formCreate')}">
				<legend><c:out value="${applicationScope.languageManager.getLanguageValue('journal_information', sessionScope.tag)}" /> </legend>
				<label for="journalOrConfName"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_name', sessionScope.tag)}" /><span
					class="requis">*</span></label> <input type="text" id="journalOrConfName"
					name="journalOrConfName" value="" size="30" maxlength="30"
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
				</select> <br /> 
<%-- 				<label for="journalOrConfState"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_state', sessionScope.tag)}" /> --%>
<!-- 				 <span class="requis">*</span> -->
<!-- 				</label> <select id="journalOrConfState" name="journalOrConfState"> -->
<!-- 					<option>0</option> -->
<!-- 					<option>1</option> -->
<!-- 					<option>2</option> -->
<!-- 					<option>3</option> -->
<!-- 				</select>  <br />-->
				 <label for="journalOrConfLogo"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_logo', sessionScope.tag)}" /> </label> <input
					type="file" id="journalOrConfLogo" name="journalOrConfLogo"
					value="" size="30" maxlength="30" /> <br /> <label
					for="journalOrConfShortDesc"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_short_desc', sessionScope.tag)}" /> </label> <input
					type="text" id="journalOrConfShortDesc"
					name="journalOrConfShortDesc" value="" size="30" maxlength="100" />
				<br /> <label for="journalOrConfLongDesc"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_long_desc', sessionScope.tag)}" />	</label>
				<textarea rows="6" cols="70" id="journalOrConfLongDesc"
					name="journalOrConfLongDesc"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_long_desc_text', sessionScope.tag)}" />
                </textarea>
			</fieldset>
			<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('journal_creation_submit_button', sessionScope.tag)}" />" /> <input
				type="reset" value="${applicationScope.languageManager.getLanguageValue('journal_cancel_button', sessionScope.tag)}" /> <br />
		</form>
	</div>
	<br><br><font color="red" size="18">${succesMessage } ${errorMessage}</font>
</body>
</html>
