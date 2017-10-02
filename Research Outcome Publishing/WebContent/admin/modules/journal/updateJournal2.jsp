<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title><c:out value="${applicationScope.languageManager.getLanguageValue('journal_update_title', sessionScope.tag)}" /></title>
<link type="text/css" rel="stylesheet"
	href="admin/modules/journal/inc/style.css" />
<script type="text/javascript" src="admin/modules/journal/inc/fonction.js"></script>
</head>
<body>
<div>
	<form method="post"
		action="<c:url value="/?m=${applicationScope.encryptor.encrypt('adminJournal')}" />&o=${applicationScope.encryptor.encrypt('ModAdminJournal')}"
		name="formUpdate2" onsubmit="return verifForm2(formUpdate2);"
		enctype="multipart/form-data">
		<fieldset>
		<input type="hidden" name="formulaire" value="${applicationScope.encryptor.encrypt('formUpdate2')} ">
		<input type="hidden" name="journalId" value="${journalId}">
			<legend><c:out value="${applicationScope.languageManager.getLanguageValue('journal_information', sessionScope.tag)}" /> </legend>
			<label for="journalOrConfName"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_name', sessionScope.tag)}" /><span																																																																																													
				class="requis">*</span></label> <input type="text" id="journalOrConfName"
				name="journalOrConfName" value="${journalName}" size="30" maxlength="30"
				onblur="verifPseudo(this);" /> <br /> <label
				for="journalOrConfName"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_type', sessionScope.tag)}" /> <span
				class="requis">*</span></label>
				
				<input type="text" id="journalOrConfType"
				name="journalOrConfType" value="${journalType}"  size="30" maxlength="30" /> 
				<br>
				<label for="journalOrConfState"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_state', sessionScope.tag)}" /> <span
				class="requis">*</span>
			    </label> 
				<input type="text" id="journalOrConfState"
				name="journalOrConfState" maxlength="1" value="${journalState}" onblur="verifState(this);" size="30" /> 
				
				 <input
				type="hidden" id="journalOrConfLogo1" name="journalOrConfLogo1"
				value="${journalLogo}" size="30" maxlength="30" />
			   
				<br /> <label for="journalOrConfLogo"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_logo', sessionScope.tag)}" /> </label>
				 <input
				type="file" id="journalOrConfLogo" name="journalOrConfLogo"
				value="" size="30" maxlength="30" /> <br /> <label
				for="journalOrConfShortDesc"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_short_desc', sessionScope.tag)}" /> </label> <input
				type="text" id="journalOrConfShortDesc"
				name="journalOrConfShortDesc" value="${journalShortDescription}" size="30" maxlength="100" />
			<br/> <label for="journalOrConfLongDesc"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_long_desc', sessionScope.tag)}" />
			</label>
			<textarea rows="6" cols="70" id="journalOrConfLongDesc"
				name="journalOrConfLongDesc">${journalDescription}
               </textarea>
		</fieldset>
		<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('journal_update_submit_button2', sessionScope.tag)}" />" name="submitValue" /> <input
			type="reset" value="<c:out value="${applicationScope.languageManager.getLanguageValue('journal_cancel_button', sessionScope.tag)}" />" /> <br />
	</form>
</div>
</body>
</html>