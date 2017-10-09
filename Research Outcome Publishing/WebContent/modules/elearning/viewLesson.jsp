<h2 class="subtitle">
	<c:out value="${currentCourse['courseName']}" />
	---
	<c:out value="${currentLesson['lessonName']}" />
</h2>
<br>
<object data="<c:url value="${currentLesson['lessonAttachment']}" />"
	type="application/pdf" style="width: 100%; height: 50%;">
	<param name="nom"
		value="<c:url value="${currentLesson['lessonAttachment']}" /> " />
	<strong> error</strong>
</object>
<br><br><br><br>
<c:choose>
	<c:when test="${baoUser != null}">
		<c:choose>
			<c:when test="${listOfIntervention!=null && listOfIntervention.size()>= 1}">

				<c:forEach items="${listOfIntervention}" var="lI">
					<div style="border : 2;">
						<div>
							<p>
								<c:out value="${lI['interventionContent']}" />
							</p>
							<p style="align: right;">
								<c:out value="${lI['interventionLike']}" />
								<a
									href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('likeIntervention')}&d=${applicationScope.encryptor.encrypt(lI['interventionId'])}"><c:out
										value="${applicationScope.languageManager.getLanguageValue('el_i_like', sessionScope.tag)}" /></a>
								<c:out value="${lI.baoInterventionList.size()}" />
								<a 
									href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('AnswerIntervention')}&d=${applicationScope.encryptor.encrypt(lI['interventionId'])}"><c:out
										 value="${applicationScope.languageManager.getLanguageValue('el_answer', sessionScope.tag)}" /></a>
							</p>
						</div>
					
					</div>
				</c:forEach>

			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		<div id="form" class="row">
			<form method="post"
				action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('AddIntervention')}"
				name="elForm" class="form col-md-12">
				<div class="form-group">
					<textarea name="comment" id="comment" cols=50 rows=5
						class="el_text_zone auth_text_zone form-control" required>
								<c:out value="${param.comment}" />
							</textarea>
				</div>
				<div class="form-group">
				<input type="submit"
					value="<c:out value="${applicationScope.languageManager.getLanguageValue('el_submit', sessionScope.tag)}" />"
					class="el_button auth_button btn btn-success" /> <input type="reset"
					value="<c:out value="${applicationScope.languageManager.getLanguageValue('el_reset', sessionScope.tag)}" />"
					class="el_button auth_button btn btn-success" />
				</div>
	
			</form>
	</div>
	</c:when>
	<c:otherwise>
		<a
			href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('login')}" />"><c:out
				value="${applicationScope.languageManager.getLanguageValue('logout_title', sessionScope.tag)}" /></a>
	</c:otherwise>
</c:choose>
