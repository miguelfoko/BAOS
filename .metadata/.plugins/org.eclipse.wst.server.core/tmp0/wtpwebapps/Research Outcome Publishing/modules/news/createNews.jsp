<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title><c:out
		value="${applicationScope.languageManager.getLanguageValue('news_creation_title', sessionScope.tag)}" /></title>
<link type="text/css" rel="stylesheet"
	href="admin/modules/journal/inc/style.css" />
<script type="text/javascript"
	src="admin/modules/journal/inc/fonction.js"></script>
</head>
<body>
	<div>
		<form method="post"
			action="<c:url value="/?m=${applicationScope.encryptor.encrypt('news')}" />&o=${applicationScope.encryptor.encrypt('ModNews')}"
			name="f1" onsubmit="return verifForm3(f1);">
			<fieldset>
				<input type="hidden" name="formulaire"
					value="${applicationScope.encryptor.encrypt('formCreateNews')}">
				<legend>
					<c:out
						value="${applicationScope.languageManager.getLanguageValue('news_title', sessionScope.tag)}" />
				</legend>
				<label for="news_title"><c:out
						value="${applicationScope.languageManager.getLanguageValue('news_title', sessionScope.tag)}" /><span
					class="requis">*</span></label> <input type="text" id="news_title"
					name="news_title" value="" size="30" maxlength="30"
					onblur="verifPseudo(this);" /><span class="requis">
<c:out
						value="${applicationScope.languageManager.getLanguageValue('news_msg1', sessionScope.tag)}" />
</span>
					 <br /> <label
					for="news_key"><c:out
						value="${applicationScope.languageManager.getLanguageValue('news_key', sessionScope.tag)}" />
					<span class="requis">*</span></label> <input type="text"
					id="news_key"
					name="news_key" value="" size="30"
					maxlength="100" onblur="verifPseudo(this);" />
					<span class="requis">
<c:out
						value="${applicationScope.languageManager.getLanguageValue('news_msg1', sessionScope.tag)}" />
</span>
 <br /> 
 
 <label
					for="news_language"><c:out
						value="${applicationScope.languageManager.getLanguageValue('news_language', sessionScope.tag)}" />
					<span class="requis">*</span></label> <input type="text"
					id="news_language"
					name="news_language" value="" size="30"
					maxlength="100" onblur="verifPseudo(this);" />
					<span class="requis">
<c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_msg1', sessionScope.tag)}" />
</span>
 <br /> 
					  <label
					for="news_keyword"><c:out
						value="${applicationScope.languageManager.getLanguageValue('news_keyword', sessionScope.tag)}" />
					</label>
					 <input type="text"
					id="news_keyword"
					name="news_keyword" value=""
					size="30" maxlength="100" /> 
					
					<br /> <label
					for="news_state"><c:out
						value="${applicationScope.languageManager.getLanguageValue('news_state', sessionScope.tag)}" />
					<span class="requis">*</span></label>
					 <input type="text"
					id="news_state"
					name="news_state" value=""
					onblur="verifState(this);" size="30" maxlength="100" /> 
					<span class="requis">0=Activated, 1=Desactivated</span>
					
					 <br />  <br><label
					for="news_content"><c:out
						value="${applicationScope.languageManager.getLanguageValue('news_content', sessionScope.tag)}" />
					<span class="requis">*</span></label>
					
					<textarea rows="6" cols="45" id="news_content"
					name="news_content" onblur="verifPseudo(this);"><c:out value="${applicationScope.languageManager.getLanguageValue('news_content', sessionScope.tag)}" />
                </textarea> 
					<span class="requis"><c:out
						value="${applicationScope.languageManager.getLanguageValue('journal_msg1', sessionScope.tag)}" />
					</span>
					
<!-- 					<br /> <label -->
<%-- 					for="news_date"><c:out --%>
<%-- 						value="${applicationScope.languageManager.getLanguageValue('news_date', sessionScope.tag)}" /> --%>
<!-- 					<span class="requis">*</span></label> -->
<!-- 					 <input type="text" -->
<!-- 					id="news_date" -->
<!-- 					name="news_date" value="" -->
<!-- 					onblur="verifState(this);" size="30" maxlength="100" />  -->
<!-- 					<span class="requis">0=Activated, 1=Desactivated</span> -->
					
					<br />
					
					<label
					for="news_user"><c:out
						value="${applicationScope.languageManager.getLanguageValue('news_user', sessionScope.tag)}" />
					<span class="requis">*</span></label> 	
					<select id="news_user" 	name="news_user" >

					<c:forEach items="${baoUser}" var="v">
						<option value="${v['userId']}"><c:out value="${v['userLogin']}"></c:out></option>
					</c:forEach>
				</select> <br />
 <br>
					
					 <label
					for="news_is_traduction"><c:out
						value="${applicationScope.languageManager.getLanguageValue('news_is_traduction', sessionScope.tag)}" />
					<span class="requis">*</span></label> 
					
					<input type="checkbox" id="news_is_traduction"
					name="news_is_traduction">

					 <br />
					 

			</fieldset>
			<input type="submit"
				value="<c:out value="${applicationScope.languageManager.getLanguageValue('news_creation_button', sessionScope.tag)}" />" />
			<input type="reset"
				value="${applicationScope.languageManager.getLanguageValue('news_cancel_button', sessionScope.tag)}" />
			<br />
		</form>
	</div>
	<br>
	<br>
	<font color="red" size="18">${succesMessage } ${errorMessage}</font>
</body>
</html>