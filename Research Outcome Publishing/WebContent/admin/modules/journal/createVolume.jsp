<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title><c:out
		value="${applicationScope.languageManager.getLanguageValue('journal_volume_title', sessionScope.tag)}" /></title>
<link type="text/css" rel="stylesheet"
	href="admin/modules/journal/inc/style.css" />
<script type="text/javascript"
	src="admin/modules/journal/inc/fonction.js"></script>
</head>
<body>
	<div>
		<form method="post"
			action="<c:url value="/?m=${applicationScope.encryptor.encrypt('adminJournal')}" />&o=${applicationScope.encryptor.encrypt('ModAdminJournal')}"
			name="f1" onsubmit="return verifForm4(f1);">
			<fieldset>
				<input type="hidden" name="formulaire"
					value="${applicationScope.encryptor.encrypt('createVolume')}">
				<legend>
					<c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_volume_information', sessionScope.tag)}" />
				</legend>
				<label
					for="journal_volume_issue_journal_or_conf"><c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_volume_issue_journal_or_conf', sessionScope.tag)}" />
					<span class="requis">*</span></label>
					
					<select id="journal_volume_issue_journal_or_conf" 	name="journal_volume_issue_journal_or_conf" >

					<c:forEach items="${baoJournalOrConf}" var="v">
						<option value="${v['journalOrConfId']}"><c:out value="${v['journalOrConfName']}"></c:out></option>
					</c:forEach>
				</select><br>
					
					
				<label
					for="journal_volume_issue_review_condition"><c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_volume_issue_review_condition', sessionScope.tag)}" />
					<span class="requis">*</span></label>
					
					<select id="journal_volume_issue_review_condition" 	name="journal_volume_issue_review_condition" >

					<c:forEach items="${baoAutomaticReviewCondition}" var="v">
						<option value="${v['reviewConditionId']}"><c:out value="${v['reviewConditionName']}"></c:out></option>
					</c:forEach>
				</select><br>
					
					<label
					for="journal_volume_issue_news"><c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_volume_issue_news', sessionScope.tag)}" />
					<span class="requis">*</span></label> 
					
					<select id="journal_volume_issue_news" 	name="journal_volume_issue_news" >

					<c:forEach items="${baoNews}" var="v">
						<option value="${v['newsId']}"><c:out value="${v['newsTitle']}"></c:out></option>
					</c:forEach>
				</select>
					<br>
					
					
				<label for="journal_volume_issue_identifier"><c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_volume_issue_identifier', sessionScope.tag)}" /><span
					class="requis">*</span></label> <input type="text" id="journal_volume_issue_identifier"
					name="journal_volume_issue_identifier" value="" size="30" maxlength="30"
					onblur="verifPseudo(this);" /><span class="requis">
<c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_msg1', sessionScope.tag)}" />
</span>
					 <br />
					  <label
					for="journal_volume_issue_submission_deadline"><c:out
 						value="${applicationScope.languageManager.getLanguageValue('journal_volume_issue_submission_deadline', sessionScope.tag)}" /> 
					<span class="requis">*</span></label> 
					
					<input type="date" id="journal_volume_issue_submission_deadline"
					 name="journal_volume_issue_submission_deadline">
					
 <br /> 

 <label
					for="journal_volume_issue_desc"><c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_volume_issue_desc', sessionScope.tag)}" />
					<span class="requis">*</span></label>
					
					<textarea rows="6" cols="45" id="journal_volume_issue_desc"
					name="journal_volume_issue_desc"><c:out value="${applicationScope.languageManager.getLanguageValue('journal_volume_issue_desc', sessionScope.tag)}" />
                </textarea> 
 <br /> 
 
 <label
					for="journal_volume_issue_state"><c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_volume_issue_state', sessionScope.tag)}" />
					<span class="requis">*</span></label> <input type="text"
					id="journal_volume_issue_state"
					name="journal_volume_issue_state" value=""
					onblur="verifState(this);" size="30" maxlength="100" /><span class="requis">0=Activated, 1=Desactivated</span>

					 <br />

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