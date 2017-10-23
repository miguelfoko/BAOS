<h2 class="subtitle"><c:out
	value="${applicationScope.languageManager.getLanguageValue('el_monitor_course', sessionScope.tag)}" /></h2>

<div id="regForm">
	<div id="form" class="row">
		<h5 class="subtitle"><c:out value="${applicationScope.languageManager.getLanguageValue('register_subtitle', sessionScope.tag)}" /></h5>
		<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('MonitorCourseNew')}" name="regForm" class="form col-md-12">
			<input type="hidden" id="modEncryptedName" value="<c:out value="${applicationScope.encryptor.encrypt('authentication')}" />" />
			<input type="hidden" id="actionEncryptedName" value="<c:out value="${applicationScope.encryptor.encrypt('check')}" />" />
			<div class="form-group">
				<label class="auth_label auth_label control-label" for="name"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_name', sessionScope.tag)}" /><span class="required">*</span></label>
				<input type="text" name="name" id="name" value="<c:out value="${param.name}" />" required class="auth_text_zone auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_name_holder', sessionScope.tag)}" />" />
				<span class="error" id="nameError"></span>
			</div>
			<div class="form-group">
				<label class="auth_label auth_label control-label" for="surname"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_surname', sessionScope.tag)}" /></label>
				<input type="text" name="surname" id="surname" value="<c:out value="${param.surname}" />" class="auth_text_zone auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_surname_holder', sessionScope.tag)}" />" />
				<span class="error" id="surnameError"></span>
			</div>
			<div class="form-group">
				<label class="auth_label auth_label control-label" for="email"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_email', sessionScope.tag)}" /><span class="required">*</span></label>
				<input type="email" name="email" id="email" value="<c:out value="${param.email}" />" required class="auth_text_zone auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_email_holder', sessionScope.tag)}" />" />
				<span class="error" id="emailError"></span>
			</div>
			
			<div class="form-group pull-right">
				<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_register', sessionScope.tag)}" />" class="el_button auth_button btn btn-success" />
				<input type="reset" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_reset', sessionScope.tag)}" />" class="el_button auth_button btn btn-success" />
			</div>
		</form>
	</div>
</div>

