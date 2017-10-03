<c:choose>
	<c:when test="${baoUser == null}">
		<div id="authForm" class="row">
			<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}" />&o=${applicationScope.encryptor.encrypt('login')}" name="authForm" class="form col-md-12">
				<legend><c:out value="${applicationScope.languageManager.getLanguageValue('auth_login_subtitle', sessionScope.tag)}" /></legend>
				<c:if test="${loginError != null}">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group alert alert-danger alert-dismissable">
								<button type="button" class="close" data-dismiss="alert"><span class="glyphicon glyphicon-remove"></span></button>
								<c:out value="${loginError}" />
							</div>
						</div>
					</div>
				</c:if>
				<div class="form-group <c:if test="${loginError != null}">has-error</c:if>">
					<label class="auth_label control-label" for="login"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_login', sessionScope.tag)}" /><span class="required">*</span></label>
					<input type="text" name="login" id="login" value="<c:out value="${param.login}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_login_holder', sessionScope.tag)}" />" />
				</div>
				<div class="form-group <c:if test="${loginError != null}">has-error</c:if>">
					<label class="auth_label control-label" for="pass"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_pass', sessionScope.tag)}" /><span class="required">*</span></label>
					<input type="password" name="pass" id="pass" required class="auth_text_zone form-control" />
				</div>
				<div class="form-group">
					<input type="checkbox" name="stayLogged" id="stayLogged" class="auth_checkbox" <c:if test="${(param.login != null && param.stayLogged != null) || param.login == null}">checked</c:if>  />
					<label class="auth_label auth_checkbox_label" for="stayLogged"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_stay_logged', sessionScope.tag)}" /></label>
				</div>
				<c:if test="${auth_redirect != null}">
					<input type="hidden" name="auth_redirect" value="<c:out value="${applicationScope.encryptor.encrypt(auth_redirect)}" />" />
				</c:if>
				<div class="form-group pull-right">
					<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_connect', sessionScope.tag)}" />" class="auth_button btn btn-success" />
					<input type="reset" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_reset', sessionScope.tag)}" />" class="auth_button btn btn-default" />
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<c:if test="${loginError != null}">
							<a href="" class="forgottenPwd btn btn-danger"><c:out value="${applicationScope.languageManager.getLanguageValue('forgotten_pwd', sessionScope.tag)}" /></a>
						</c:if>
						<a class="baosButton btn btn-default" href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('register')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('create_account', sessionScope.tag)}" /></a>
					</div>
				</div>
			</form>
		</div>
	</c:when>
	<c:otherwise>
		<a class="btn btn-danger" href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('logout')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('logout_title', sessionScope.tag)}" /></a>
	</c:otherwise>
</c:choose>