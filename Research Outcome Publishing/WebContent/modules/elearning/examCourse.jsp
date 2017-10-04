<h4 class="subtitle">
<c:out
	value="${applicationScope.languageManager.getLanguageValue('el_exam_course', sessionScope.tag)}" />
</h4>
<c:choose>
	<c:when test="${baoUser != null}">
		<div id="elForm" class="2-b_article 1st-b_article b_article">
			<div id="form">
				<form  method="post"
					action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('ExamCourse')}"
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
					<label class="el_label" for="end"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_end_time', sessionScope.tag)}" /></label>
					<input type="date" name="end" id="end" class="el_text_zone"
						value="<c:out value="${dateToday}"/>"  min="<c:out value="${dateToday}"/>"  required
						 placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_end_time', sessionScope.tag)}" />" /><br />
					<label class="el_label" for="length"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_length', sessionScope.tag)}" /></label>
					<input type="number" name="length" id="length" class="el_text_zone"
						min=1 value="<c:out value="${param.length}" />" required /><br />
					<label class="el_label" for="plength"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_pause_length', sessionScope.tag)}" /></label>
					<input type="number" name="plength" id="plength" class="el_text_zone"
						min=1 value="<c:out value="${param.plength}" />" required /><br />
					<label class="el_label" for="level"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_diff_level', sessionScope.tag)}" /></label>
					<input type="number" name="level" id="level" class="el_text_zone"
						min=1 value="<c:out value="${param.level}" />" required/><br />
					<label class="el_label" for="number"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_question_number', sessionScope.tag)}" /></label>
					<input type="number" name="number" id="number" class="el_text_zone"
						min=1 value="<c:out value="${param.number}" />" required/><br />
					<label class="el_label" for="mark"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_question_mark', sessionScope.tag)}" /></label>
					<input type="number" name="mark" id="mark" class="el_text_zone"
						min=1 value="<c:out value="${param.mark}" />" required/><br />
					<label class="el_label" for="result"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_result_delay', sessionScope.tag)}" /></label>
					<input type="date" name="result" id="result" class="el_text_zone"
						value="<c:out value="${dateToday}"/>"  min="<c:out value="${dateToday}"/>"  required /><br />
					<label class="el_label" for="admis"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_admission_level', sessionScope.tag)}" /></label>
					<input type="number" name="admis" id="admis" class="el_text_zone"
						min=1 value="<c:out value="${param.admis}" />" required/><br />
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