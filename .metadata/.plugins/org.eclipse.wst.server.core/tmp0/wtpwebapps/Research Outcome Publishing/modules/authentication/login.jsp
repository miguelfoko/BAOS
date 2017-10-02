<c:choose>
	<c:when test="${baoUser == null}">
		<div id="authForm" class="2-b_article 1st-b_article b_article">
			<div id="form">
				<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('login')}" />" name="authForm" class="form">
					<label class="auth_label" for="login"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_login', sessionScope.tag)}" /></label>
					<input type="text" name="login" id="login" value="<c:out value="${param.login}" />" required class="auth_text_zone" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_login_holder', sessionScope.tag)}" />" /><br />
					<label class="auth_label" for="pass"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_pass', sessionScope.tag)}" /></label>
					<input type="password" name="pass" id="pass" class="auth_text_zone" /><br />
					<input type="checkbox" name="stayLogged" id="stayLogged" class="auth_checkbox" <c:if test="${(param.login != null && param.stayLogged != null) || param.login == null}">checked</c:if>  />
					<label class="auth_label auth_checkbox_label" for="stayLogged"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_stay_logged', sessionScope.tag)}" /></label><br />
					<c:if test="${auth_redirect != null}">
						<input type="hidden" name="auth_redirect" value="<c:out value="${applicationScope.encryptor.encrypt(auth_redirect)}" />" />
					</c:if>
					<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_connect', sessionScope.tag)}" />" class="auth_button" />
					<input type="reset" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_reset', sessionScope.tag)}" />" class="auth_button" /><br />
					<c:if test="${loginError != null}">
						<a href="" class="forgottenPwd"><c:out value="${applicationScope.languageManager.getLanguageValue('forgotten_pwd', sessionScope.tag)}" /></a>
					</c:if>
				</form>
			</div>
		</div>
		<div id="regButtons" class="2-b_article lst-b_article b_article">
			
		</div>
	</c:when>
	<c:otherwise>
		<a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('logout')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('logout_title', sessionScope.tag)}" /></a>
	</c:otherwise>
</c:choose>