<c:out
	value="${applicationScope.languageManager.getLanguageValue('el_timetable_course', sessionScope.tag)}" />
<br>
<br>
<br>
<c:choose>
	<c:when test="${baoUser != null}">
		<div id="elForm" class="2-b_article 1st-b_article b_article">
			<div id="form">
				<form method="post"
					action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('TimetableCourse')}"
					name="elForm" class="form">
					<label class="el_label" for="name"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_name', sessionScope.tag)}" /></label>
					<input type="text" name="name" id="name"
						value="<c:out value="${param.name}" />" required
						class="el_text_zone"
						placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_name', sessionScope.tag)}" />" /><br />
					<label class="el_label" for="day"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_jour', sessionScope.tag)}" /></label>
					<select name="day" id="day" class="el_text_zone">
						<option>
							<c:out
								value="${applicationScope.languageManager.getLanguageValue('el_lundi', sessionScope.tag)}" />
						</option>
						<option>
							<c:out
								value="${applicationScope.languageManager.getLanguageValue('el_mardi', sessionScope.tag)}" />
						</option>
						<option>
							<c:out
								value="${applicationScope.languageManager.getLanguageValue('el_mercredi', sessionScope.tag)}" />
						</option>
						<option>
							<c:out
								value="${applicationScope.languageManager.getLanguageValue('el_jeudi', sessionScope.tag)}" />
						</option>
						<option>
							<c:out
								value="${applicationScope.languageManager.getLanguageValue('el_vendredi', sessionScope.tag)}" />
						</option>
						<option>
							<c:out
								value="${applicationScope.languageManager.getLanguageValue('el_samedi', sessionScope.tag)}" />
						</option>
						<option>
							<c:out
								value="${applicationScope.languageManager.getLanguageValue('el_dimanche', sessionScope.tag)}" />
						</option>
					</select><br />
					<label class="el_label" for="start"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_start_time', sessionScope.tag)}" /></label>
					<input type="time" name="start" id="start"
						class="el_text_zone" value="<c:out value="${param.startTime}" />"
						required
						placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_start_time', sessionScope.tag)}" />" />
					<label class="el_label" for="end"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_end_time', sessionScope.tag)}" /></label>
					<input type="time" name="end" id="end" class="el_text_zone"
						value="<c:out value="${param.endTime}" />" required
						placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_end_time', sessionScope.tag)}" />" />
					<input type="submit"
						value="<c:out value="${applicationScope.languageManager.getLanguageValue('el_submit', sessionScope.tag)}" />"
						class="el_button" /> <input type="reset"
						value="<c:out value="${applicationScope.languageManager.getLanguageValue('el_reset', sessionScope.tag)}" />"
						class="el_button" /><br />
					<c:if test="${timetableCourseError != null}">
						<em><c:out
								value="${applicationScope.languageManager.getLanguageValue('el_timetable_course_error', sessionScope.tag)}" /></em>
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