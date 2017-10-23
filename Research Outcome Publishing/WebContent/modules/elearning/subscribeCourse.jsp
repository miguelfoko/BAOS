<h2 class="subtitle"><c:out
	value="${applicationScope.languageManager.getLanguageValue('el_subscribe_course', sessionScope.tag)}" /></h2>



<div id="elForm" class="2-b_article 1st-b_article b_article">
	<div id="form" class="row">
		<form method="post"
			action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('subscribeCourseOld')}"
			name="elForm" class="form form-inline col-md-12">
			<div class="form-group">
				<label class="el_label auth_label control-label" for="email"><c:out
						value="${applicationScope.languageManager.getLanguageValue('el_email', sessionScope.tag)}" /><span class="required">*</span></label>
				<input type="search" name="email" id="email"
					onkeyup="showData2(this.value);" required class="el_text_zone auth_text_zone form-control"
					placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_email', sessionScope.tag)}" />" />
			</div>
			<div class="form-group">
				<input type="submit"
					value="<c:out value="${applicationScope.languageManager.getLanguageValue('el_submit', sessionScope.tag)}" />"
					class="el_button auth_button btn btn-success" /> <input type="reset"
					value="<c:out value="${applicationScope.languageManager.getLanguageValue('el_reset', sessionScope.tag)}" />"
					class="el_button auth_button btn btn-success" />
			</div>
		</form>

		<p>
			<a
				href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('subscribeCourseNew')}"><c:out
					value="${applicationScope.languageManager.getLanguageValue('el_new_student', sessionScope.tag)}" /></a>
		</p>
	</div>
</div>
