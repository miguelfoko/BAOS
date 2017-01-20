<div id="form">
	<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}" />&o=${applicationScope.encryptor.encrypt('login')}" name="authForm" class="form">
		<label class="auth_label"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_login', sessionScope.tag)}" /></label>
		<input type="text" name="login" value="<c:out value="${param.login}" />" required class="auth_text_zone" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_login_holder', sessionScope.tag)}" />" /><br />
		<label class="auth_label"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_pass', sessionScope.tag)}" /></label>
		<input type="password" name="pass" class="auth_text_zone" /><br />
		<input type="checkbox" name="stayLogged" class="auth_checkbox" checked /><label class="auth_label auth_checkbox_label"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_stay_logged', sessionScope.tag)}" /></label><br />
		<c:if test="${redirect != null}">
			<input type="hidden" name="redirect" value="<c:out value="${redirect}" />" />
		</c:if>
		<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_connect', sessionScope.tag)}" />" class="auth_button" />
		<input type="reset" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_reset', sessionScope.tag)}" />" class="auth_button" />
	</form>
</div>