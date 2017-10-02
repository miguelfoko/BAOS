<h4 class="subtitle">
	<c:out
		value="${applicationScope.languageManager.getLanguageValue('elearning', sessionScope.tag)}" />
</h4>
<br>
<div id="elForm" class="2-b_article 1st-b_article b_article">
	<div id="form">
		<form method="post"
			action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('CreateCourse')}"
			name="elForm" class="form">
			<label class="el_label" for="search"><c:out
					value="${applicationScope.languageManager.getLanguageValue('el_search', sessionScope.tag)}" /></label>
			<input type="search" name="search"
				value="<c:out value="${param.search}" />" required
				placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_search', sessionScope.tag)}" />" />
			<label class="el_label" for="option"><c:out
					value="${applicationScope.languageManager.getLanguageValue('el_option', sessionScope.tag)}" /></label>
			<select name="option" id="option" class="el_text_zone">
				<option value="1">
					<c:out
						value="${applicationScope.languageManager.getLanguageValue('el_all_course', sessionScope.tag)}" />
				</option>
				<option value="2">
					<c:out
						value="${applicationScope.languageManager.getLanguageValue('el_course_taught', sessionScope.tag)}" />
				</option>
				<option value="3">
					<c:out
						value="${applicationScope.languageManager.getLanguageValue('el_course_directed', sessionScope.tag)}" />
				</option>
				<option value="4">
					<c:out
						value="${applicationScope.languageManager.getLanguageValue('el_course_followed', sessionScope.tag)}" />
				</option>
			</select> <label> </label> <input type="submit"
				value="<c:out value="${applicationScope.languageManager.getLanguageValue('el_submit', sessionScope.tag)}" />"
				class="el_button" />
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
						href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('viewCourse')}&d=${applicationScope.encryptor.encrypt(uC['courseId'])}"><c:out
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



