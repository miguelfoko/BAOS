<h2 class="subtitle"><c:out
	value="${applicationScope.languageManager.getLanguageValue('el_pay_course', sessionScope.tag)}" /></h2>



<div id="elForm" class="2-b_article 1st-b_article b_article">
	<div id="form" class="row">
		<form method="post"
			action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('PayCourse')}"
			name="elForm" class="form col-md-12">
			<div class="form-group">
				<input type="submit"
					value="<c:out value="${applicationScope.languageManager.getLanguageValue('el_submit', sessionScope.tag)}" />"
					class="el_button auth_button btn btn-success" /> <input type="reset"
					value="<c:out value="${applicationScope.languageManager.getLanguageValue('el_reset', sessionScope.tag)}" />"
					class="el_button auth_button btn btn-success" />
			</div>
		</form>
	</div>
</div>
