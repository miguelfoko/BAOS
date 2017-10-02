<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title><c:out
		value="${applicationScope.languageManager.getLanguageValue('journal_review_title', sessionScope.tag)}" /></title>
<link type="text/css" rel="stylesheet"
	href="admin/modules/journal/inc/style.css" />
<script type="text/javascript"
	src="admin/modules/journal/inc/fonction.js"></script>
</head>
<body>
	<div>
		<form method="post"
			action="<c:url value="/?m=${applicationScope.encryptor.encrypt('adminJournal')}" />&o=${applicationScope.encryptor.encrypt('ModAdminJournal')}"
			name="f1" onsubmit="return verifForm3(f1);">
			<fieldset>
				<input type="hidden" name="formulaire"
					value="${applicationScope.encryptor.encrypt('formCreateReviewCondition')}">
				<legend>
					<c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_review_information', sessionScope.tag)}" />
				</legend>
				<label for="journal_review_name"><c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_review_name', sessionScope.tag)}" /><span
					class="requis">*</span></label> <input type="text" id="journal_review_name"
					name="journal_review_name" value="" size="30" maxlength="30"
					onblur="verifPseudo(this);" /><span class="requis">
<c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_msg1', sessionScope.tag)}" />
</span>
					 <br /> <label
					for="journal_review_condition_max_reviewer"><c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_review_condition_max_reviewer', sessionScope.tag)}" />
					<span class="requis">*</span></label> <input type="text"
					id="journal_review_condition_max_reviewer"
					name="journal_review_condition_max_reviewer" value="" size="30"
					maxlength="100" onblur="verifState1(this);" />
					<span class="requis">
<c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_msg2', sessionScope.tag)}" />
</span>
 <br /> 
 
 <label
					for="journal_review_condition_max_paper_allowed"><c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_review_condition_max_paper_allowed', sessionScope.tag)}" />
					<span class="requis">*</span></label> <input type="text"
					id="journal_review_condition_max_paper_allowed"
					name="journal_review_condition_max_paper_allowed" value="" size="30"
					maxlength="100" onblur="verifState1(this);" />
					<span class="requis">
<c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_msg2', sessionScope.tag)}" />
</span>
 <br /> 
 
 <label
					for="journal_review_condition_paper_success_percent"><c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_review_condition_paper_success_percent', sessionScope.tag)}" />
					<span class="requis">*</span></label> <input type="text"
					id="journal_review_condition_paper_success_percent"
					name="journal_review_condition_paper_success_percent" value=""
					onblur="verifState2(this);" size="30" maxlength="100" />
					<span class="requis">
<c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_msg3', sessionScope.tag)}" />
</span>
					 <br /> <label
					for="journal_review_condition_state"><c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_review_condition_state', sessionScope.tag)}" />
					<span class="requis">*</span></label> <input type="text"
					id="journal_review_condition_state"
					name="journal_review_condition_state" value=""
					onblur="verifState(this);" size="30" maxlength="100" /> 
					<span class="requis">0=Activated, 1=Desactivated</span>
					<br /> <label
					for="journal_review_condition_accept_without_editor"><c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_review_condition_accept_without_editor', sessionScope.tag)}" />
					<span class="requis">*</span></label>
					
					<input type="checkbox" id="journal_review_condition_accept_without_editor"
					name="journal_review_condition_accept_without_editor">
					 <br /> <label
					for="journal_review_condition_user"><c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_review_condition_user', sessionScope.tag)}" />
					<span class="requis">*</span></label> 	
					<select id="journal_review_condition_user" 	name="journal_review_condition_user" >

					<c:forEach items="${baoUser}" var="v">
						<option value="${v['userId']}"><c:out value="${v['userLogin']}"></c:out></option>
					</c:forEach>
				</select> <br />

			</fieldset>
			<input type="submit"
				value="<c:out value="${applicationScope.languageManager.getLanguageValue('journal_review_creation_submit_button', sessionScope.tag)}" />" />
			<input type="reset"
				value="${applicationScope.languageManager.getLanguageValue('journal_cancel_button', sessionScope.tag)}" />
			<br />
		</form>
	</div>
	<br>
	<br>
	<font color="red" size="18">${succesMessage } ${errorMessage}</font>
</body>
</html>