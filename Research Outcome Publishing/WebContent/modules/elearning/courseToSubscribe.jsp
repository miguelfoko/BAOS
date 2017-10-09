<h4 class="subtitle">
	<c:out
		value="${applicationScope.languageManager.getLanguageValue('el_click_course', sessionScope.tag)}" />
</h4>
<br>
<div id="elForm" class="2-b_article 1st-b_article b_article">
	<div id="form" class="row">
		<form method="post"
			action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('CreateCourse')}"
			name="elForm" class="form col-md-12">
			<div class="form-group">
				<label class="el_label auth_label control-label" for="search"><c:out
						value="${applicationScope.languageManager.getLanguageValue('el_search', sessionScope.tag)}" /><span class="required">*</span></label>
				<input type="search" name="search"
					value="<c:out value="${param.search}" />" required class="el_text_zone auth_text_zone form-control"
					placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_search', sessionScope.tag)}" />" />
			</div>
			<div class="form-group pull-right">
				<input type="submit"
					value="<c:out value="${applicationScope.languageManager.getLanguageValue('el_submit', sessionScope.tag)}" />"
					class="el_button auth_button btn btn-success" />
			</div>
		</form>
	</div>
</div>

<br>
<c:choose>
	<c:when test="${userCourse!=null && userCourse.size()>= 1}">
		<table>
			<c:forEach items="${userCourse}" var="uC">
				<p>
					<img src="<c:url value="${uC['courseLogo']}"/>" width="100"
						height="100" /> <a
						href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('subscribeCourse')}&d=${applicationScope.encryptor.encrypt(uC['courseId'])}"><c:out
							value="${uC['courseName']}" /></a>
					<c:out value="${uC['courseDesc']}" />
					<br>
				</p>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<c:out
			value="${applicationScope.languageManager.getLanguageValue('el_no_course', sessionScope.tag)}" />
	</c:otherwise>
</c:choose>



