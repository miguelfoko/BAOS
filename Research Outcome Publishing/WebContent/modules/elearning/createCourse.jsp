<h4 class="subtitle">
<c:out
	value="${applicationScope.languageManager.getLanguageValue('el_create_course', sessionScope.tag)}" />
</h4>
<c:choose>
	<c:when test="${baoUser != null}">
		<div id="elForm" class="2-b_article 1st-b_article b_article">
			<div id="form">
				<form enctype="multipart/form-data" method="post"
					action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('CreateCourse')}"
					name="elForm" class="form">
					<label class="el_label" for="name"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_name', sessionScope.tag)}" /></label>
					<input type="text" name="name" id="name"
						value="<c:out value="${param.name}" />" required
						class="el_text_zone"
						placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_name', sessionScope.tag)}" />" /><br />
					<label class="el_label" for="start"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_start_time', sessionScope.tag)}" /></label>
					<input type="date" name="start" id="start" class="el_text_zone"
						value="<c:out value="${dateToday}"/>"  min="<c:out value="${dateToday}"/>"  required
						 placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_start_time', sessionScope.tag)}" />" /><br />
					<label class="el_label" for="length"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_length', sessionScope.tag)}" /></label>
					<input type="number" name="length" id="length" class="el_text_zone"
						min=1 value="<c:out value="${param.length}" />" required
						placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_length', sessionScope.tag)}" />" /><br />
					<label class="el_label" for="lengthUnit"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_length_unit', sessionScope.tag)}" /></label>
					<select name="lengthUnit" id="lengthUnit" class="el_text_zone">
						<option value="Hours">
							<c:out
								value="${applicationScope.languageManager.getLanguageValue('Hours', sessionScope.tag)}" />
						</option>
						<option value="Days">
							<c:out
								value="${applicationScope.languageManager.getLanguageValue('Days', sessionScope.tag)}" />
						</option>
						<option value="Months">
							<c:out
								value="${applicationScope.languageManager.getLanguageValue('Months', sessionScope.tag)}" />
						</option>
						<option value="Years">
							<c:out
								value="${applicationScope.languageManager.getLanguageValue('Years', sessionScope.tag)}" />
						</option>
					</select><br /> 
					<label class="el_label" for="file"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_icon', sessionScope.tag)}" /></label>
					<input type="file" name="file" id="file" class="el_text_zone" min=1
						value="<c:out value="${param.file}" />" required
						placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_icon', sessionScope.tag)}" />" /><br />
					<label class="el_label" for="desc"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_desc', sessionScope.tag)}" /></label>
					<textarea name="desc" id="desc" cols=50 rows= 5 class="el_text_zone" required
						placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_desc', sessionScope.tag)}" />">
						<c:out value="${param.desc}" />
					</textarea>
					<br /> <input type="submit"
						value="<c:out value="${applicationScope.languageManager.getLanguageValue('el_submit', sessionScope.tag)}" />"
						class="el_button" /> <input type="reset"
						value="<c:out value="${applicationScope.languageManager.getLanguageValue('el_reset', sessionScope.tag)}" />"
						class="el_button" /><br />
					<c:if test="${createCourseError != null}">
						<em><c:out
								value="${applicationScope.languageManager.getLanguageValue('el_create_course_error', sessionScope.tag)}" /></em>
					</c:if>
				</form>
			</div>
		</div>
		<div id="regButtons" class="2-b_article lst-b_article b_article">

		</div>
	</c:when>
	<c:otherwise>
		<a
			href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('login')}" />"><c:out
				value="${applicationScope.languageManager.getLanguageValue('logout_title', sessionScope.tag)}" /></a>
	</c:otherwise>
</c:choose>