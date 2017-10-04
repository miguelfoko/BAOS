<h4 class="subtitle">
	<c:out
		value="${applicationScope.languageManager.getLanguageValue('el_lesson_course', sessionScope.tag)}" />
</h4>

<c:choose>
	<c:when test="${baoUser != null}">
		<div id="elForm" class="2-b_article 1st-b_article b_article">
			<div id="form">
				<form method="post"
					action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('QuestionCourse')}"
					name="elForm" class="form">
					<label class="el_label" for="contenu"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_contenu', sessionScope.tag)}" /></label>
					<textarea name="contenu" id="contenu" cols=50 rows=5
						class="el_text_zone" required
						placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_contenu', sessionScope.tag)}" />">
						<c:out value="${param.contenu}" />
					</textarea><br/>
					<label class="el_label" for="proposal"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_proposal', sessionScope.tag)}" /></label>
					<textarea name="proposal" id="proposal" cols=50 rows=5
						class="el_text_zone" required
						placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_proposal', sessionScope.tag)}" />">
						<c:out value="${param.proposal}" />
					</textarea><br/>
					<label class="el_label" for="answer"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_answer', sessionScope.tag)}" /></label>
					<input type="number" name="answer" id="answer" min=1 max=5 />
					<br/>
					<label class="el_label" for="level"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_diff_level', sessionScope.tag)}" /></label>
					<input type="number" name="level" id="level" min=1 max=5 />
					<br /><label class="el_label" for="forexam"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_forexam', sessionScope.tag)}" /></label>
					<input type="radio" name="forexam" id="forexam" value ="true" /><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_true', sessionScope.tag)}" />
					<input type="radio" name="forexam" id="forexam" value ="false" /><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_false', sessionScope.tag)}" />
					<br /> 
					<label class="el_label" for="justify"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_justification_required', sessionScope.tag)}" /></label>
					<input type="radio" name="justify" id="justify" value ="true" /><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_true', sessionScope.tag)}" />
					<input type="radio" name="justify" id="justify" value ="false" /><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_false', sessionScope.tag)}" />
					<br />
					<label class="el_label" for="justification"><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_justification', sessionScope.tag)}" /></label>
					<textarea name="justification" id="justification" cols=50 rows=5
						class="el_text_zone" required placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_justification', sessionScope.tag)}" />">
						<c:out value="${param.justification}" />
					</textarea>
					<br/>
					 <input type="submit"
						value="<c:out value="${applicationScope.languageManager.getLanguageValue('el_submit', sessionScope.tag)}" />"
						class="el_button" /> <input type="reset"
						value="<c:out value="${applicationScope.languageManager.getLanguageValue('el_reset', sessionScope.tag)}" />"
						class="el_button" /><br />
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