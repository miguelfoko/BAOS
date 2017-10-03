<div id="regForm" class="row">
	<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}" />&o=${applicationScope.encryptor.encrypt('register')}" name="regForm" class="form col-md-12">
		<legend><c:out value="${applicationScope.languageManager.getLanguageValue('register_subtitle', sessionScope.tag)}" /></legend>
		<c:if test="${registerError != null}">
			<div class="row">
				<div class="col-md-12">
					<div class="form-group alert alert-danger alert-dismissable">
						<button type="button" class="close" data-dismiss="alert"><span class="glyphicon glyphicon-remove"></span></button>
						<c:out value="${registerError}" />
					</div>
				</div>
			</div>
		</c:if>
		<input type="hidden" id="modEncryptedName" value="<c:out value="${applicationScope.encryptor.encrypt('authentication')}" />" />
		<input type="hidden" id="actionEncryptedName" value="<c:out value="${applicationScope.encryptor.encrypt('check')}" />" />
		<input type="hidden" id="wrongConfirmPass" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_wrong_confirm_pass', sessionScope.tag)}" />" />
		<div id="form-name-group" class="form-group <c:if test="${registerNameError != null}">has-error</c:if>">
			<label class="auth_label control-label" for="name"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_name', sessionScope.tag)}" /><span class="required">*</span></label>
			<input type="text" name="name" id="name" value="<c:out value="${param.name}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_name_holder', sessionScope.tag)}" />" />
			<span class="help-block" id="nameError"><c:out value="${registerNameError}" /></span>
		</div>
		<div class="form-group">
			<label class="auth_label" for="surname"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_surname', sessionScope.tag)}" /></label>
			<input type="text" name="surname" id="surname" value="<c:out value="${param.surname}" />" class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_surname_holder', sessionScope.tag)}" />" />
		</div>
		<div id="form-email-group" class="form-group <c:if test="${registerEmailError != null}">has-error</c:if>">
			<label class="auth_label control-label" for="email"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_email', sessionScope.tag)}" /><span class="required">*</span></label>
			<input type="email" name="email" id="email" value="<c:out value="${param.email}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_email_holder', sessionScope.tag)}" />" />
			<span class="help-block" id="emailError"><c:out value="${registerEmailError}" /></span>
		</div>
		<div id="form-login-group" class="form-group <c:if test="${registerLoginError != null}">has-error</c:if>">
			<label class="auth_label control-label" for="login"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_login', sessionScope.tag)}" /><span class="required">*</span></label>
			<input type="text" name="login" id="login" value="<c:out value="${param.login}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_login_holder_2', sessionScope.tag)}" />" />
			<span class="help-block" id="loginError"><c:out value="${registerLoginError}" /></span>
		</div>
		<div id="form-pass-group" class="form-group <c:if test="${registerPassError != null}">has-error</c:if>">
			<label class="auth_label control-label" for="pass"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_pass', sessionScope.tag)}" /><span class="required">*</span></label>
			<input type="password" name="pass" id="pass" class="auth_text_zone form-control" required />
			<span class="help-block" id="passError"><c:out value="${registerPassError}" /></span>
		</div>		
		<div id="form-confirm-pass-group" class="form-group <c:if test="${registerConfirmPassError != null}">has-error</c:if>">
			<label class="auth_label control-label" for="confirmPass"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_confirm_pass', sessionScope.tag)}" /><span class="required">*</span></label>
			<input type="password" name="confirmPass" id="confirmPass" class="auth_text_zone form-control" required />
			<span class="help-block" id="confirmPassError"><c:out value="${registerConfirmPassError}" /></span>
		</div>
		<div class="form-group pull-right">
			<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_register', sessionScope.tag)}" />" class="auth_button btn btn-success" />
			<input type="reset" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_reset', sessionScope.tag)}" />" class="auth_button btn btn-default" />
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<a class="baosButton btn btn-default" href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('login')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_login_menu_title', sessionScope.tag)}" /></a>
			</div>
		</div>
	</form>
</div>
